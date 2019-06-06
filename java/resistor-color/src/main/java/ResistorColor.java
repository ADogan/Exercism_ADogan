class ResistorColor {
    int colorCode(String color) {
        String[] colors = colors();
        Integer returnValue = null;
        for(int i = 0; i < colors.length; i++){
            if (color.equals(colors[i])){
                returnValue = i;
            }
        }
        return returnValue;
    }

    String[] colors() {
        String[] colorsArray = new String[10];
        colorsArray[0] = "black";
        colorsArray[1] = "brown";
        colorsArray[2] = "red";
        colorsArray[3] = "orange";
        colorsArray[4] = "yellow";
        colorsArray[5] = "green";
        colorsArray[6] = "blue";
        colorsArray[7] = "violet";
        colorsArray[8] = "grey";
        colorsArray[9] = "white";
        return colorsArray;
    }
}