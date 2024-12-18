import java.io.File;
import java.util.Scanner;

/**
 * @author Qifei Wang
 * @version 1
 */

public class DNA {
    /**
     * 
     * @param fileName data file name
     * @return DNARecord
     */

    public static DNARecord[] readData(String fileName) {
        DNARecord[] records = new DNARecord[20];
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            int index = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                Profile profile = new Profile();
                profile.setAgatCount(Integer.parseInt(data[1]));
                profile.setAatgCount(Integer.parseInt(data[2]));
                profile.setTatcCount(Integer.parseInt(data[3]));
                records[index++] = new DNARecord(data[0], profile);
            }
            scanner.close();

        } catch (Exception e) {
            return null;
        }
        return records;
    }

    /**
     * 
     * @param sequence SEQUENCE
     * @param match    MATCH
     * @return MAX MATCHES
     */

    public static int countMaximumConsecutiveMatches(String sequence, String match) {
        int maxMatches = 0;
        int sequenceIndex = 0;
        while (sequenceIndex < sequence.length()) {
            int counter = 0;
            while (sequence.startsWith(match, sequenceIndex)) {
                counter++;
                sequenceIndex += match.length();
            }
            maxMatches = Math.max(maxMatches, counter);
            sequenceIndex++;
        }
        return maxMatches;
    }

    /**
     * 
     * @param fileName filename
     * @return profile
     */

    public static Profile readSequence(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String sequence = scanner.nextLine();
            scanner.close();

            Profile profile = new Profile();
            profile.setAgatCount(countMaximumConsecutiveMatches(sequence, "AGAT"));
            profile.setAatgCount(countMaximumConsecutiveMatches(sequence, "AATG"));
            profile.setTatcCount(countMaximumConsecutiveMatches(sequence, "TATC"));
            return profile;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * @param args args
     */

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the filenames for data and sequence.");
            return;
        }
        String fileName = args[0];
        String sequenceFileName = args[1];
        DNARecord[] records = readData(fileName);
        Profile profile = readSequence(sequenceFileName);
        boolean matchFound = false;
        for (DNARecord record : records) {
            if (record != null && record.getProfile().equals(profile)) {
                System.out.println("Matched " + record.getName() + ": " + record.getProfile().toString());
                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            System.out.println("No match for " + profile.toString());
        }

    }
}