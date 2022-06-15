public class Board 
{
  private String[][] square;

  public Board() 
  {
    square = new String[10][10];
    for(int i = 0; i < square.length; i++) 
    {
      for(int k = 0; k < square[0].length; k++) 
      {
        square[i][k] = "-";
      }
    }
  }

  public String toString() 
  {
    String print = "";
    for(int r = 0; r < square.length; r++) 
    {
      for(int c = 0; c < square[0].length; c++) 
      {
        print += square[r][c] + " ";
      }
    print += "\n";
    }
    return print;
  }

  public boolean addShip(int row, int col, int len, boolean horizontal) 
  {
    if (row < 0 || col < 0 || row >= square.length || col >= square[0].length)
    {
      return false;
    }
   
    if(horizontal) 
    {
      if(col + len > square.length) return false;
   
      for(int c = col; c < col+len; c++) 
      {
        if(!square[row][c].equals("-")) return false;
      }
      
      for(int c = col; c < col+len; c++) 
      {
        square[row][c] = "b";
      }
    }
   
    else 
    {
      if(row + len > square.length) return false;
   
      for(int r = row; r < row+len; r++) 
      {
        if(!square[r][col].equals("-")) return false;
      }
      for(int r = row; r < row+len; r++) 
      {
        square[r][col] = "b";
      }  
    }
   return true;
  }


  public boolean foundShip(int len) 
  {
    for(int i = 0; i < square.length; i++) 
    {
    int counter = 0;
    while(counter < square[0].length) 
    {
      int foundLen = 0;
      while(counter < square[0].length && square[i][counter].equals("b")) 
      {
        foundLen++;
        counter++;
      }
      if(foundLen == len) return true;
      foundLen = 0;
      counter++;
    }
  }
    
    for(int k = 0; k < square[0].length; k++) 
    {
    int counter = 0;
    while(counter < square.length) 
    {
      int foundLen = 0;
      while(counter < square.length && square[counter][k].equals("b")) 
      {
        foundLen++;
        counter++;
      }
    if(foundLen == len) return true;
    foundLen = 0;
    counter++;
    }    
  }
  return false;
}

  public int shoot(int row, int col) 
  {
    if (row < 0 || col < 0 || row >= square.length || col >= square[0].length)
    return -1;
    
    if(square[row][col].equals("-"))
    {
      square[row][col] = "m";
      return 0;
    }
    if(square[row][col].equals("b")) 
    {
      square[row][col] = "x";
      return 1;
    }
    return 2;
  }

  public boolean gameOver() 
  {
    for(int r = 0; r < square.length; r++) 
    {
      for(int c = 0; c < square[0].length; c++) 
      {
        if(square[r][c].equals("b")) return false;
      }
    }    
    return true;
  }

}