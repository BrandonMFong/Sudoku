public class Hash 
{
    // NO ZERO INDEX
    int Row;
    int Column;
    class Block
    {
        int Num;

        // The following two methods returns the top left row/column index
        public int GetRow() 
        {
            if((Num == 1)||(Num == 2)||(Num == 3)) return 1;
            else if((Num == 4)||(Num == 5)||(Num == 6)) return 3;
            else if((Num == 7)||(Num == 8)||(Num == 9)) return 6;
            else return 0;
        }
        public int GetColumn() 
        {
            if((Num == 1)||(Num == 4)||(Num == 7)) return 1;
            else if((Num == 2)||(Num == 5)||(Num == 8)) return 3;
            else if((Num == 3)||(Num == 6)||(Num == 9)) return 6;
            else return 0;
        }
    }
}
