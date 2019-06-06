import java.util.HashMap;
import java.util.Random;

class DnDCharacter {
    private HashMap<String, Integer> abilitiesMap = new HashMap<>();
    private int hitpoints = 0;
    private final int NUMBER_OF_DICES = 4;
    private final int NUMBER_DICE_SIDES = 6;
    private final int INITIAL_HITPOINTS= 10;

    DnDCharacter(){
        // Add all abilities
        abilitiesMap.put("strength", 0);
        abilitiesMap.put("dexterity", 0);
        abilitiesMap.put("constitution", 0);
        abilitiesMap.put("intelligence", 0);
        abilitiesMap.put("wisdom", 0);
        abilitiesMap.put("charisma", 0);

        // Loop through all abilities
        abilitiesMap.forEach((abilityKey, number) -> {
            abilitiesMap.replace(abilityKey, generateAbilityScore());
        });
        setHitpoints();
    }
    private void setHitpoints() {
        hitpoints = INITIAL_HITPOINTS + modifier(abilitiesMap.get("constitution"));
    };

    int ability() {
        return generateAbilityScore();
    }

    private int generateAbilityScore(){
        int[] randomNumbers = new int[NUMBER_OF_DICES];
        for(int i = 0; i < NUMBER_OF_DICES; i++){
            randomNumbers[i] = getRandomNumberBelow(NUMBER_DICE_SIDES);
        }

        randomNumbers = removeLowestNumber(randomNumbers);
        int sumOfRandomNumbers = calculateSumOfRandomNumbers(randomNumbers);
        return sumOfRandomNumbers;
    }

    int modifier(int input) {
        double inputSubtractedBy10 = input - 10;
        double inputDividedBy2 = inputSubtractedBy10 / 2;
        int roundedDown = (int)Math.floor(inputDividedBy2);
        return roundedDown;
    }

    private int calculateSumOfRandomNumbers(int[] randomNumbers){
        int sum = 0;
        for(int i = 0; i < randomNumbers.length; i++){
            sum += randomNumbers[i];
        }
        return sum;
    }

    private int[] removeLowestNumber(int[] randomNumbers) {
        int lowestNumber = Integer.MAX_VALUE;
        for(int i = 0; i < randomNumbers.length; i++){
            if(randomNumbers[i] < lowestNumber){
                lowestNumber = randomNumbers[i];
            }
        }

        for(int i = 0; i < randomNumbers.length; i ++){
            if(randomNumbers[i] == lowestNumber){
                randomNumbers[i] = 0;
                return randomNumbers;
            }
        }
        return randomNumbers;
    }

    private int getRandomNumberBelow(int i) {
        Random randomNumber = new Random();
        int newRandomNumber = randomNumber.nextInt(i) + 1;
        return newRandomNumber;
    }

    int getStrength() {
        return abilitiesMap.get("strength");
    }

    int getDexterity() {
        return abilitiesMap.get("dexterity");
    }

    int getConstitution() {
        return abilitiesMap.get("constitution");
    }

    int getIntelligence() {
        return abilitiesMap.get("intelligence");
    }

    int getWisdom() {
        return abilitiesMap.get("wisdom");
    }

    int getCharisma() {
        return abilitiesMap.get("charisma");
    }

    int getHitpoints() {
        return hitpoints;
    }
}