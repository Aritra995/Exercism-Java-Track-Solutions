class ResistorColor {
    int colorCode(String color) {
        int colorCode = 0;
        String[] colorsArray = colors();
        for (int index = 0; index < colorsArray.length; index++) {
            if (color.equals(colorsArray[index])) {
                colorCode = index;
                break;
            }
        }
        return colorCode;
    }

    String[] colors() {
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        return colors;
    }
}
