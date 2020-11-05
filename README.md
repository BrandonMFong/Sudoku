# Sudoku

The program uses the Backtracking algorithm that takes an unsolved sudoku board and provides a solution for it.  

## To Use
Create the directory ".\input\" and make a file named "Matrix.csv".  In the Matrix.csv file must be the sudoku board with length and width of 9, and ideally would be unsolved.

The solution will be written in ".\output\Solution.csv". 

### Example Matrix.csv file
```
,7,,,8,,,,
5,1,,7,9,,,,4
4,6,,,2,,5,,
2,,,8,1,,9,,
6,3,4,,,,8,5,1
,,1,,5,4,,,3
,,5,,6,,,3,8
8,,,,4,9,,1,7
,,,,3,,,9,
```

## Demo

### Input
![Input Sudoku](https://github.com/BrandonMFong/Sudoku/blob/main/img/InputBoardPrint.PNG)

### Output
![Input Sudoku](https://github.com/BrandonMFong/Sudoku/blob/main/img/OutputBoardPrint.PNG)

# Dev Notes

To create .jar
```
jar cmf <manifest file> <Name of .jar file> <.class file, .class file,...>
jar cmf .\manifest.txt Sudoku.jar .\Sudoku.class .\Hash.class '.\Hash$Block.class'
```

# Author
Brandon Fong
