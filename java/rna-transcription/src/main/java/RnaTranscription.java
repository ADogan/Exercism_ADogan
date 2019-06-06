class RnaTranscription {

    String transcribe(String dnaStrand) {
        String RNAStrand = "";
        for(char c: dnaStrand.toCharArray()){
            char complementingNucleotide = 0;
            try {
                complementingNucleotide = getComplementingNucleotide(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            RNAStrand += "" + complementingNucleotide;
        }
    return RNAStrand;
    }

    private char getComplementingNucleotide(char c) throws Exception {
        char returnNucleotide = ' ';
        switch(c) {
            case 'G':
                returnNucleotide = 'C';
                break;
            case 'C':
                returnNucleotide = 'G';
                break;
            case 'T':
                returnNucleotide = 'A';
                break;
            case 'A':
                returnNucleotide = 'U';
                break;
        }
        if(returnNucleotide == ' ') {
            throw new Exception("No complementing Nucleotide found");
        }
        return returnNucleotide;
    }

}

