public class Hash 
{
    // NO ZERO INDEX
    // Keeps track of the current index we are solving
    private int Row;
    private int Column;
    private Block Block = new Block();

    // GET
    public int GetRow(){return this.Row;}
    public int GetColumn(){return this.Column;}
    public int GetBlockNum(){return this.Block.Num;}

    // SET
    public void SetRow(int value)
    {
        this.Row = value;
        SetBlockNum();
    }
    public void SetColumn(int value)
    {
        this.Column = value;
        SetBlockNum();
    }

    // Evaluates block number from the value of the rows
    // evaluated by setting col/row num
    private void SetBlockNum()
    {
        for(int i = 0; i < 3; i++) // row of blocks
        {
            for(int k = 0; k < 3; k++) // column of blocks
            {
                if((((1*i)<=this.Row) && (this.Row<=(3*i))) && (((1*k)<=this.Column) && (this.Column<=(3*k))))
                {
                    // not setting correctly 
                    this.Block.SetNum(i+1); // Assign block number
                    return;
                }
            }
        }
    }
    class Block
    {
        private int Num;

        public int GetNum() {return this.Num;}
        public void SetNum(int value) {this.Num = value;}

        // do I need the following? 

        // The following two methods returns the top left row/column index
        // public int GetRow() 
        // {
        //     if((Num == 1)||(Num == 2)||(Num == 3)) return 1;
        //     else if((Num == 4)||(Num == 5)||(Num == 6)) return 3;
        //     else if((Num == 7)||(Num == 8)||(Num == 9)) return 6;
        //     else return 0;
        // }
        // public int GetColumn() 
        // {
        //     if((Num == 1)||(Num == 4)||(Num == 7)) return 1;
        //     else if((Num == 2)||(Num == 5)||(Num == 8)) return 3;
        //     else if((Num == 3)||(Num == 6)||(Num == 9)) return 6;
        //     else return 0;
        // }
    }
}
