import java.awt.*;
import java.awt.event.*;
public class ZeroCross extends Frame implements ActionListener{
	class Close extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	Font font=new Font("Consolas",Font.BOLD,30);
	Button bt[]=new Button[9];
	static int n=0;
	boolean win=false;
	ZeroCross(){
		super("Tic Tac Toe Game");
		addWindowListener(new Close());
		setLayout(new GridLayout(3,3));
		String a[]={"Click","Anywhere","To","Start","Playing","Tic","Tac","Toe","Game"};
		for(int i=0;i<9;++i){
			bt[i]=new Button(a[i]);
			add(bt[i]);
			bt[i].setFont(font);
			bt[i].addActionListener(this);
		}
		setBounds(450,170,450,450);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(win==false){
			if(n==0){
				for(int i=0;i<9;++i){
					bt[i].setLabel("");
				}
			}
			Button b=((Button)e.getSource());
			if(n%2==0){
				if(b.getLabel().equals("0")||b.getLabel().equals("X"))
					return;
				b.setLabel("0");
				b.setBackground(Color.CYAN);
			}
			else{
				if(b.getLabel().equals("0")||b.getLabel().equals("X"))
					return;
				b.setLabel("X");
				b.setBackground(Color.MAGENTA);
			}
			n++;
			if(n>=3){
				if(winner("X")){
					win=true;	
					Dialog d=new Dialog(this,"Player 2 Wins");
					d.setLayout(new FlowLayout());
					d.addWindowListener(new Close());
					d.setBounds(450,300,400,100);
					d.add(new Label("Player 2 Wins"));
					d.setVisible(true);
				}
				else if(winner("0")){
					win=true;
					Dialog d=new Dialog(this,"Player 1 Wins");
					d.setLayout(new FlowLayout());
					d.addWindowListener(new Close());
					d.setBounds(450,300,400,100);
					d.add(new Label("Player 1 Wins"));
					d.setVisible(true);		
				}
			}
			if(n==9&&win==false){
				Dialog d=new Dialog(this,"Tie");
				d.setLayout(new FlowLayout());
				d.addWindowListener(new Close());
				d.setBounds(450,300,400,100);
				d.add(new Label("It's a TIE !!!"));
				d.setVisible(true);
			}		
		}
	}
	boolean winner(String c){
		if(bt[0].getLabel().equals(c)&&bt[1].getLabel().equals(c)&&bt[2].getLabel().equals(c))
			return true;
		else if(bt[3].getLabel().equals(c)&&bt[4].getLabel().equals(c)&&bt[5].getLabel().equals(c))
			return true;
		else if(bt[6].getLabel().equals(c)&&bt[7].getLabel().equals(c)&&bt[8].getLabel().equals(c))
			return true;
		else if(bt[0].getLabel().equals(c)&&bt[3].getLabel().equals(c)&&bt[6].getLabel().equals(c))
			return true;
		else if(bt[1].getLabel().equals(c)&&bt[4].getLabel().equals(c)&&bt[7].getLabel().equals(c))
			return true;
		else if(bt[2].getLabel().equals(c)&&bt[5].getLabel().equals(c)&&bt[8].getLabel().equals(c))
			return true;
		else if(bt[0].getLabel().equals(c)&&bt[4].getLabel().equals(c)&&bt[8].getLabel().equals(c))
			return true;
		else if(bt[2].getLabel().equals(c)&&bt[4].getLabel().equals(c)&&bt[6].getLabel().equals(c))
			return true;
		else 
			return false;
	}
	public static void main(String[] args){
		new ZeroCross();
	}
}