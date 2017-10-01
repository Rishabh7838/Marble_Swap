import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class Marble extends JFrame implements ActionListener 
{
  JButton b[][],bj;
Object op = new Object();
boolean bo,b11,b22,b33;
String s1="",s2="";
Container c1,c2;
int a1=-10,a2=-10,b1=-10,b2=-10,p=5,i,j,f,t,con,an,lx;
JPanel l,l2;
JLabel l1;
Marble()
 {
  b = new JButton[7][7];
int i,j;
l= new JPanel(new  GridLayout(7,7,0,0));
c1 = this.getContentPane();
c2 = this.getContentPane();
Font f1 = new Font("Algerian",Font.BOLD,15);
Font f2 = new Font("Algerian",Font.BOLD,35);
l1= new JLabel("MARBLE SWAP..       remove all the red boxes");
String s1[][]={
   { "a","a","x","x","x","a","a","a"},
   { "a","a","x","x","x","a","a","a"},
   { "x","x","x","x","x","x","x","x"},
   { "x","x","x","0","x","x","x","x"},
   { "x","x","x","x","x","x","x","x"},
   { "a","a","x","x","x","a","a","a"},
   { "a","a","x","x","x","a","a","a"},
   
};
for(i=0;i<b.length;i++)
 {
  for(j=0;j<b.length;j++)
{
if((i<2||i>4)&&(j<2||j>4))
{
   b[i][j]=new JButton(s1[i][j]);
 b[i][j].setFont(f1);
b[i][j].setVisible(false);
b[i][j].setBackground(Color.RED);
b[i][j].setPreferredSize(new Dimension(100,100));
  l.add(b[i][j]);
}
else
{
      b[i][j]=new JButton(s1[i][j]);
   b[i][j].addActionListener(this);
   b[i][j].setForeground(Color.WHITE);
  b[i][j].setBackground(Color.RED);
  b[i][j].setPreferredSize(new Dimension(100,100));
  l.add(b[i][j]);
}
 }
}
b[3][3].setBackground(Color.WHITE);
c2.setBackground(Color.BLACK);
c2.setLayout(new FlowLayout());
l1.setForeground(Color.ORANGE);
l1.setFont(f2);
c2.add(l1,BorderLayout.NORTH);
c2.add(l);
//add(c2);
setSize(900,900);
setVisible(true);
 }
  public void actionPerformed(ActionEvent e)
  { for(int re=0;re<2;re++)
      {
for(i=0;i<b.length;i++)
 {
  for(j=0;j<b.length;j++)
{ if(b[i][j].getText().equals("x"))
lx++;
 s1+=b[i][j].getText();
  s2+=b[j][i].getText();
  
 }if(s1.contains("xx0")||s1.contains("0xx"))
 { t=1;
   //System.out.println(s1);
 }
 if(s2.contains("xx0")||s2.contains("0xx"))
 {con=1;
   //System.out.println(s2);
 }
 s1="";
 s2="";
 }
an=33-lx;
if(t==0&&con==0)
   JOptionPane.showMessageDialog(null, "Game over   Score = "+an);
lx=t=con=0;
  JButton  bj = (JButton)e.getSource();
String s=bj.getText();
for(i=0;i<b.length;i++)
 {
  for(j=0;j<b.length;j++)
{
  if(b[i][j]==bj)
  {
    if(s=="x")
    {
      a1=i;
      b1=j;
      s=" ";
 
    }
    if(s=="0")
    {
      a2=i;
      b2=j;
      s=" ";
      f++;
    }
    if((((a2-a1)==2||(a2-a1)==-2)&& b1==b2) && (b[(a1+a2)/2][b1].getText().equals("x")))
    {
    b[a1][b1].setText("0");
    b[a1][b1].setBackground(Color.WHITE);
    b[(a1+a2)/2][b1].setBackground(Color.WHITE);
  b[(a1+a2)/2][b1].setText("0");  
  b[a2][b2].setText("x");
    b[a2][b2].setBackground(Color.RED);
  a1=a2=b1=b2=-10;
  f=0;
  }
    else if((((b2-b1)==2||(b2-b1)==-2)&& a1==a2) && (b[a1][(b1+b2)/2].getText().equals("x")))
    {
        b[a1][b1].setText("0");
    b[a1][b1].setBackground(Color.WHITE);
    b[a1][(b1+b2)/2].setBackground(Color.WHITE);
  b[a1][(b1+b2)/2].setText("0");  
  b[a2][b2].setText("x");
    b[a2][b2].setBackground(Color.RED);
  a1=a2=b1=b2=-10;
  f=0;
  }   if(f!=0)
     {
       a1=a2=b1=b2=-10;
       f=0;
     }
  }
}
     }
/**/

}
}
  public static void main(String... s)
  {
    Marble m= new Marble();
m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}