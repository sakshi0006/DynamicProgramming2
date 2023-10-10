class Solution {
    public void solveSudoku(char[][] board) {
         solve(board,0,0);
    }

/*int solve(char**,int,int);
int cRow(char**,char ,int);
int cCol(char**,char,int);
int cBox(char**,char,int,int);
void solveSudoku(char** board, int boardSize, int* boardColSize){
     
    solve(board,0,0);
}*/
int solve(char board[][] , int i, int j)
{
    if(j==9)
    {
        j=0;i++;
    }
    if(i==9)
    {
        return 1;
    }
    char ch=board[i][j];
    if(ch=='.')
    {
        int fg=0;
        for(char k='1';k<='9';k++)
        {
            if(cRow(board,k,i)==1&&cCol(board,k,j)==1&&cBox(board,k,i,j)==1)
            {
                board[i][j]=k;
                if(solve(board,i,j+1)==1)
                {
                    fg=1;break;
                }
            }
        }
        if(fg==0)board[i][j]='.';
        return fg;
    }
    return solve(board, i,j+1);
}
int cRow(char board[][],char k,int r)
{
    for(int i=0;i<9;i++)
    {
        if(board[r][i]==k)return 0;
    }
  return 1;   
 }
int cCol(char board[][],char k,int c)
{
    for(int i=0;i<9;i++)
    {
        if(board[i][c]==k)return 0;
    }
  return 1;   
 }
int cBox(char board[][],char k,int r,int c)
{
    int i=(r/3)*3,j=(c/3)*3;
    for(int l=i;l<i+3;l++)
    {
        for(int m=j;m<j+3;m++)
        {
        if(board[l][m]==k&&!(l==r&&m==c))return 0;
        }
    }
  return 1;   
 }
}
