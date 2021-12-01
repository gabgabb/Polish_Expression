package plep.utils;

public enum TypeOperateur {

    PLUS,MOINS,DIVISE,MULTIPLIE,INVERSE,RACINE;

    public static String mapping(TypeOperateur to){
        switch (to) {
            case PLUS:
                return "+";
            case MOINS:
                return "-";
            case DIVISE:
                return "/";
            case MULTIPLIE:
                return "*";
            case INVERSE:
                return "inv";
            case RACINE:
                return "racine";
            default:
               return "Symbole non connu";
        }
    }
}

