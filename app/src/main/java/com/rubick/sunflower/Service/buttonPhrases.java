package com.rubick.sunflower.Service;

public class buttonPhrases {
    private static String[] Phrases = {
            "Preciso de um conselho", //1
            "Quero rir...talvez?", //2
            "POR FAVOR NÃO CLICA", //3
            "Tô meio deprê", //4
            "Tô com saudade", //5
            "Fofo", //6
            "Que tal algo aleatório?", //7
            "Manda uma curiosidade aí", //8
            "Preciso me inspirar...", //9
            "A DECIDIR" //10
    };

    public static String[] getPhrases(){
        return Phrases;
    }

    public static String getIndexPhrases(int index){
        return Phrases[index-1];
    }
}
