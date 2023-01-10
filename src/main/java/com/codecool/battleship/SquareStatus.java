package com.codecool.battleship;

public enum SquareStatus {

        //The SquareStatus enum represents possible square statuses (empty, ship, hit, missed).
        EMPTY, SHIP, HIT, MISSED;


        //Each SquareStatus has a unicode character that can be used for printing it out.
        // This unicode character is returned by a SquareStatus.GetCharacter() method.
        public char GetCharacter(){
            if (this == SquareStatus.EMPTY){
                    return 'E';
            } else if (this == SquareStatus.HIT){
                    return 'H';
            } else if (this == SquareStatus.SHIP) {
                    return 'S';
            }  else {
                    return 'M';
            }
        }


}
