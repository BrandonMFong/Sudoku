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
        for(int i = 1; i <= 3; i++) // row of blocks
        {
            for(int k = 1; k <= 3; k++) // column of blocks
            {
                if((((1*(i)<=this.Row) && (this.Row<=(3*i))) && (((1*k)<=this.Column) && (this.Column<=(3*k)))))
                {
                    // what happens when we are in block 4
                    this.Block.SetNum(i+k-1); // Assign block number
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

    }
}
