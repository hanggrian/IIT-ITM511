class NuclearWasteStorage {
  int dangerLevel;
  Lock lock;

  void lockDoor() {
    int entryCode = lock.getEntryCode();
    boolean safe;
    if (entryCode == lock.authorizedCode) {
      int shieldStatus = Shield.getStatus();
      if (shieldStatus == Shield.inPlace()) {
        int radiationLevel = RadSensor.get();
        if (radiationLevel < dangerLevel) {
          safe = true;
        } else {
          safe = false;
        }
      } else {
        safe = false;
      }

      if (safe) {
        Door.locked = false;
        Door.unlock();
      } else {
        Door.lock();
        Door.locked = true;
      }
    }
  }
}

class Shield {
  static int inPlace() {
    return 0;
  }

  static int getStatus() {
    return 0;
  }
}

class RadSensor {
  static int get() {
    return 0;
  }
}

class Door {
  static boolean locked;

  static void lock() {
  }

  static void unlock() {
  }
}

class Lock {
  int authorizedCode;

  int getEntryCode() {
    return 0;
  }
}
