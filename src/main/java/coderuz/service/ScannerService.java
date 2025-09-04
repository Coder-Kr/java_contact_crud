package coderuz.service;

import java.util.Scanner;

public class ScannerService {
    private Scanner strScanner;
    private Scanner numScanner;

    public ScannerService() {
        this.strScanner = new Scanner(System.in);
        this.numScanner = new Scanner(System.in);
    }

    public Scanner getStrScanner() {
        return strScanner;
    }

    public Scanner getNumScanner() {
        return numScanner;
    }
}

