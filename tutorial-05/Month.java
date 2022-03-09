public enum Month{ // the ordering might not be the best...
    April, August, December, February, January, July, June, March, May, November, October, September;

    /**
     * Maps each Month to an integer 1-12
     * @return current Month object's sequence number (int)
     */
    public int map() {
        switch (this) {
            case January: return 1;
            case February: return 2;
            case March: return 3;
            case April: return 4;
            case May: return 5;
            case June: return 6;
            case July: return 7;
            case August: return 8;
            case September: return 9;
            case October: return 10;
            case November: return 11;
            case December: return 12;
            default: return 0; // error case
        }
    }
}