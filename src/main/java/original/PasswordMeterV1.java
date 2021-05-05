package original;

public class PasswordMeterV1 {
    private int score;
    private String password;
    private String sComplexity = "Too Short";

    // Results
    private int bonusLength, countLength;
    private int bonusAlphaUC, countAlphaUC;
    private int bonusAlphaLC, countAlphaLC;
    private int bonusNumber, countNumber;
    private int bonusSymbol, countSymbol;
    private int bonusMidChar, countMidChar;
    private int bonusRequirements, countRequirements;
    private int bonusAlphasOnly, countAlphasOnly;
    private int bonusNumbersOnly, countNumbersOnly;
    private int bonusRepChar, countRepChar;
    private int bonusConsecutiveAlphaUC, countConsecutiveAlphaUC;
    private int bonusConsecutiveAlphaLC, countConsecutiveAlphaLC;
    private int bonusConsecutiveNumber, countConsecutiveNumber;
    private int bonusSeqAlpha, countSeqAlpha;
    private int bonusSeqNumber, countSeqNumber;
    private int bonusSeqSymbol, countSeqSymbol;

    private String[] levelsOfMandatoryItems = new String[5];
    private String[] levelsOfBonusItems = new String[2];
    private String[] levelsOfSuggestedItems = new String[9];


    private void setScore(int value) {
        score += value;
    }
    public void internalLoopThroughPasswordToCheckForRepeatCharacters (double incrementDeductionOfRepeatedChars, String[] arrPwd, int i) {
        var bCharExists = false;
        for (int j = 0; j < arrPwd.length; j++) {
            if (arrPwd[i].equals(arrPwd[j]) && i != j) { /* repeat character exists */
                bCharExists = true;
                incrementDeductionOfRepeatedChars += Math.abs(arrPwd.length / (j - i));
            }
        }
        if (bCharExists) {
            countRepChar++;
            int countUniqueCharacters = arrPwd.length - countRepChar;
            incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                    Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                    Math.ceil(incrementDeductionOfRepeatedChars);
        }
    }

    public int checkForSequentialPatterns(String sequence, String candidate){
        int aux = 0;
        for (int i = 0; i < 8; i++) {
            String sFwd = sequence.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidate.toLowerCase().contains(sFwd) || candidate.toLowerCase().contains(sRev)) {
                aux++;
            }
        }
        return aux;
    }

    /* Determine complexity based on overall score */
    String complexity() {
        if (score < 20) {
            return "Very Weak";
        } else if (score < 40) {
            return "Weak";
        } else if (score < 60) {
            return "Good";
        } else if (score < 80) {
            return "Strong";
        } else {
            return "Very Strong";
        }
    }


    /* General point assignment */
    int pointAssignment(int value, int multiplier){
        value *= multiplier;
        setScore(value);
        return value;
    }

    int pointPoorPractices(int value){
        setScore(-value);
        return value;
    }
    /*-------------------------------------------------------------------------------------*/

    public void checkPassword(String candidate) {
        password = candidate;
        int multiplierLength = 4;

        Integer nTmpAlphaUC = null, nTmpAlphaLC = null, nTmpNumber = null;
        double incrementDeductionOfRepeatedChars = 0;

        score = candidate.length() * multiplierLength;
        countLength = candidate.length();
        String[] arrPwd = candidate.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        countConsecutiveAlphaUC++;
                    }
                }
                nTmpAlphaUC = i;
                countAlphaUC++;
            } else if (arrPwd[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveAlphaLC++;
                    }
                }
                nTmpAlphaLC = i;
                countAlphaLC++;
            } else if (arrPwd[i].matches("[0-9]")) {
                if (i > 0 && i < arrPwd.length - 1) {
                    countMidChar++;
                }
                if (nTmpNumber != null) {
                    if (nTmpNumber + 1 == i) {
                        countConsecutiveNumber++;
                    }
                }
                nTmpNumber = i;
                countNumber++;
            } else if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                if (i > 0 && i < arrPwd.length - 1) {
                    countMidChar++;
                }
                countSymbol++;
            }

            /* Internal loop through password to check for repeat characters */
            internalLoopThroughPasswordToCheckForRepeatCharacters(incrementDeductionOfRepeatedChars, arrPwd, i);

        }


        /* Check for sequential alpha string patterns (forward and reverse) */
        countSeqAlpha = checkForSequentialPatterns("abcdefghijklmnopqrstuvwxyz",candidate);

        /* Check for sequential numeric string patterns (forward and reverse) */
        countSeqNumber = checkForSequentialPatterns("01234567890",candidate);

        /* Check for sequential symbol string patterns (forward and reverse) */
        countSeqSymbol = checkForSequentialPatterns(")!@#$%^&*()",candidate);


        /* Modify overall score value based on usage vs requirements */

        /* General point assignment */
        bonusLength = score;
        if (countAlphaUC > 0 && countAlphaUC < countLength) {
            bonusAlphaUC = pointAssignment((countLength - countAlphaUC), 2);
        }
        if (countAlphaLC > 0 && countAlphaLC < countLength) {
            bonusAlphaLC = pointAssignment((countLength - countAlphaLC), 2);
        }
        if (countNumber > 0 && countNumber < countLength) {
            bonusNumber = pointAssignment(countNumber, 4);
        }
        if (countSymbol > 0) {
            bonusSymbol = pointAssignment(countSymbol, 6);
        }
        if (countMidChar > 0) {
            bonusMidChar = pointAssignment(countMidChar, 2);
        }

        /* Point deductions for poor practices */
        if ((countAlphaLC > 0 || countAlphaUC > 0) && countSymbol == 0 && countNumber == 0) {  // Only Letters
            setScore(-countLength);

            countAlphasOnly = countLength;
            bonusAlphasOnly = countLength;
        }
        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {  // Only Numbers
            setScore(-countLength);

            countNumbersOnly = countLength;
            bonusNumbersOnly = countLength;
        }

        if (countRepChar > 0) {  // Same character exists more than once
            bonusRepChar = Math.abs(pointAssignment(- (int) incrementDeductionOfRepeatedChars, 1));
        }
        if (countConsecutiveAlphaUC > 0) {  // Consecutive Uppercase Letters exist
            bonusConsecutiveAlphaUC = Math.abs(pointAssignment(-countConsecutiveAlphaUC, 2));
        }
        if (countConsecutiveAlphaLC > 0) {  // Consecutive Lowercase Letters exist
            bonusConsecutiveAlphaLC = Math.abs(pointAssignment(- countConsecutiveAlphaLC, 2));
        }
        if (countConsecutiveNumber > 0) {  // Consecutive Numbers exist
            bonusConsecutiveNumber = Math.abs(pointAssignment(- countConsecutiveNumber, 2));
        }
        if (countSeqAlpha > 0) {  // Sequential alpha strings exist (3 characters or more)
            bonusSeqAlpha = Math.abs(pointAssignment(- countSeqAlpha, 3));
        }
        if (countSeqNumber > 0) {  // Sequential numeric strings exist (3 characters or more)
            bonusSeqNumber = Math.abs(pointAssignment(- countSeqNumber, 3));
        }
        if (countSeqSymbol > 0) {  // Sequential symbol strings exist (3 characters or more)
            bonusSeqSymbol = Math.abs(pointAssignment(- countSeqSymbol, 3));
        }

        /* Determine if mandatory requirements have been met and set image indicators accordingly */
        int[] arrChars = {countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol};
        String[] arrCharsIds = {"countLength", "countAlphaUC", "countAlphaLC", "countNumber", "countSymbol"};
        var arrCharsLen = arrChars.length;
        int MINIMUM_LENGTH = 8;
        for (int i = 0; i < arrCharsLen; i++) {

            int minVal = arrCharsIds[i].equals("countLength") ? MINIMUM_LENGTH - 1 : 0;
            if (arrChars[i] == minVal + 1) {
                countRequirements++;
                levelsOfMandatoryItems[i] = "sufficient";
            } else if (arrChars[i] > minVal + 1) {
                countRequirements++;
                levelsOfMandatoryItems[i] = "exceptional";
            } else {
                levelsOfMandatoryItems[i] = "failure";
            }
        }

        int nMinReqChars = candidate.length() >= MINIMUM_LENGTH ? 3 : 4;
        if (countRequirements > nMinReqChars) {  // One or more required characters exist
            score = score + countRequirements * 2;
            bonusRequirements = countRequirements * 2;
        }

        /* Determine if additional bonuses need to be applied and set image indicators accordingly */
        arrChars = new int[]{countMidChar, countRequirements};
        arrCharsIds = new String[]{"countMidChar", "countRequirements"};
        arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            int minVal = arrCharsIds[c].equals("countRequirements") ? nMinReqChars : 0;
            if (arrChars[c] == minVal + 1) {
                levelsOfBonusItems[c] = "sufficient";
            } else if (arrChars[c] > minVal + 1) {
                levelsOfBonusItems[c] = "exceptional";
            } else {
                levelsOfBonusItems[c] = "failure";
            }
        }

        /* Determine if suggested requirements have been met and set image indicators accordingly */
        arrChars = new int[]{countAlphasOnly, countNumbersOnly, countRepChar, countConsecutiveAlphaUC,
                countConsecutiveAlphaLC, countConsecutiveNumber, countSeqAlpha, countSeqNumber, countSeqSymbol};
        arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            levelsOfSuggestedItems[c] = arrChars[c] > 0 ? "warning" : "sufficient";
        }

        /* Determine complexity based on overall score */
        if (score > 100) {
            score = 100;
        } else if (score < 0) {
            score = 0;
        }
        sComplexity = complexity();
    }

    @Override
    public String toString() {
        return "Password: " + password
                + "\nScore: " + score
                + "\nComplexity: " + sComplexity

                + "\nAddictions"
                + "\n[C: " + countLength + " | B: " + bonusLength + "] Number of Characters"
                + "\n[C: " + countAlphaUC + " | B: " + bonusAlphaUC + "] Uppercase Letters"
                + "\n[C: " + countAlphaLC + " | B: " + bonusAlphaLC + "] Lowercase Letters"
                + "\n[C: " + countNumber + " | B: " + bonusNumber + "] Numbers"
                + "\n[C: " + countSymbol + " | B: " + bonusSymbol + "] Symbols"
                + "\n[C: " + countMidChar + " | B: " + bonusMidChar + "] Middle Numbers or Symbols"
                + "\n[C: " + countRequirements + " | B: " + bonusRequirements + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + countAlphasOnly + " | B: " + bonusAlphasOnly + "] Letters Only"
                + "\n[C: " + countNumbersOnly + " | B: " + bonusNumbersOnly + "] Numbers Only"
                + "\n[C: " + countRepChar + " | B: " + bonusRepChar + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + countConsecutiveAlphaUC + " | B: " + bonusConsecutiveAlphaUC + "] Consecutive Uppercase Letters"
                + "\n[C: " + countConsecutiveAlphaLC + " | B: " + bonusConsecutiveAlphaLC + "] Consecutive Lowercase Letters"
                + "\n[C: " + countConsecutiveNumber + " | B: " + bonusConsecutiveNumber + "] Consecutive Numbers"
                + "\n[C: " + countSeqAlpha + " | B: " + bonusSeqAlpha + "] Sequential Letters"
                + "\n[C: " + countSeqNumber + " | B: " + bonusSeqNumber + "] Sequential Numbers"
                + "\n[C: " + countSeqSymbol + " | B: " + bonusSeqSymbol + "] Sequential Symbols";
    }
}

