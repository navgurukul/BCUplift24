    class Identity {
    private int aadharNumber;
    private int PANNumber;

    Identity(int aadharNumber, int PANNumber) {
        this.aadharNumber = aadharNumber;
        this.PANNumber = PANNumber;
    }

    @Override
    public String toString() {
        return "Aadhar Number: " + aadharNumber + ", PAN Number: " + PANNumber;
    }
}