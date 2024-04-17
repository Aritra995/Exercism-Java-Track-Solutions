import java.util.HashMap;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        char[] dna = dnaStrand.toCharArray();
        String rnaStrand = "";
        HashMap<Character, Character> dnaMap = new HashMap<Character, Character>();
        dnaToRnaNucleotideMap(dnaMap);

        for( char nucleotide : dna ){
            rnaStrand = transcribeDnaToRna(nucleotide, rnaStrand, dnaMap);
        }
        return rnaStrand;
    }

    private String transcribeDnaToRna(char nucleotide, String rna, HashMap<Character, Character> dnaMap) {
        rna += dnaMap.get(nucleotide);
        return rna;
    }

    private void dnaToRnaNucleotideMap(HashMap<Character, Character> dnaMap) {
        dnaMap.put('G', 'C');
        dnaMap.put('C', 'G');
        dnaMap.put('T', 'A');
        dnaMap.put('A', 'U');
    }

}
