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
        for(int i = 1; i < 9; i = i + 3) // row of blocks
        {
            // int BlockOffset = 0;
            for(int k = 1; k < 9; k = k + 3) // column of blocks
            {
                if((((i)<=this.Row) && (this.Row<=(i+2))) && (((k)<=this.Column) && (this.Column<=(k+2))))
                {
                    // what happens when we are in block 4
                    this.Block.SetNum(i+(k/3)); // Assign block number
                    return;
                }
                // BlockOffset++;
            }
        }
    }

    /* Block Map */
    // []=====[]=====[]=====[]
    // []     []     []     []
    // []  1  []  2  []  3  []
    // []     []     []     []
    // []=====[]=====[]=====[]
    // []     []     []     []
    // []  4  []  5  []  6  []
    // []     []     []     []
    // []=====[]=====[]=====[]
    // []     []     []     []
    // []  7  []  8  []  9  []
    // []     []     []     []
    // []=====[]=====[]=====[]
    class Block
    {
        private int Num;
        
        // Row/Col param in block   
        private int RowArray[] = new int[2];
        private int ColArray[] = new int[2];

        public int GetNum() {return this.Num;}
        public int [] GetRowArray(){return this.RowArray;}
        public int [] GetColArray(){return this.ColArray;}

        public void SetNum(int value) 
        {
            this.Num = value;

            // Determine Column block
            int x = value % 3;
            ColArray[1] = (x == 0) ? 9 : x * 3; // 3n%3 = 0
            ColArray[0] = ColArray[1] - 2;

            // Determine Row Block 
            int y = value / 3;
            RowArray[1] = (x == 0) ? y + 1 : y;
            // TODO finish algorithm to figure out the row/col ranges
        }

    }
}
