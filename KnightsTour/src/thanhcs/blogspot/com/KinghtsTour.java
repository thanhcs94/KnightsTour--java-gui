package thanhcs.blogspot.com;

public class KinghtsTour extends JFrame implements ActionListener{

    
    private GridLayout g=new GridLayout(8,8);
    private JButton [][]btn=new JButton[8][8];
    private int BC[][]=new int[8][8] ;
    private int Dr[] = { 1, -1, -2, -2, -1,  1, 2,  2};
    private int Dc[] = {-2, -2, -1,  1,  2,  2, 1, -1};
    private JPanel ptop,pcent;
    public static int INIT_X=-1 , INIT_Y = -1;
    public KinghtsTour()
    {
        //super("The Knight's Tour - ThanhCS94");
        setTitle("Nguyen Van Thanh() - The Knight's Tour - ThanhCS94");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        setSize(550,550);
        int x=this.getToolkit().getScreenSize().width/2-300;
        int y=this.getToolkit().getScreenSize().height/2-300;
        setLocation(x,y);
        this.setLayout(new BorderLayout());
        this.setLayout(g);
        khoiTao();
        XuatBC();
        // init for JButton [][]btn=new JButton[8][8]  first
        for(JButton[] bt : btn)
            {
        //        System.out.println("length "+bt.length);
                for(final JButton bt2 : bt)
                {
                    bt2.addActionListener(new  ActionListener() {
                        
                        public void actionPerformed(ActionEvent e) {
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if(bt2==btn[i][j])
                                    {
                                        System.out.println("click Position ("+i+", "+j+")");
                                        INIT_X = i;
                                        INIT_Y =j;
                                        
                                    }
                                }
                            }
                            
                        }
                    });
                }
            }
    }

    //
    public int  TinhGTH(int d,int c)
    {
        int h=0;
        
        for(int i=0;i<8;i++)
        {
            int dong=d+Dr[i];
            int cot=c+Dc[i];
            
            if(dong>=0 && dong<8 &&cot>=0 && cot<8 && BC[dong][cot]==0)
                h++;
        }
//        System.out.println("h = "+h);
        return h;
    }

   
    public void xuat1oco(int d,int c,int value)
    {     
        
    int t=0;

    String flag=new String();
    flag=btn[d][c].getText();
//    while(t<100000000) t++;

    System.out.println("Position : ("+d+", "+c+")" + " ---- "+value);

    btn[d][c].setIcon(new ImageIcon("horse.png"));  
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    
    }


    //ma di tuan
    public int maDiTuan(int d,int c)
    {
        int buoc=1;
        BC[d][c]=buoc; 
        
        while(buoc<64)
        {
            int min=8,vtdm=-1,vtcm=-1,h;
            for(int i=0;i<8;i++)
            {
                int dt=d+Dr[i];
                int ct=c+Dc[i];

                if(dt>=0 && dt<8 && ct>=0 && ct<8 && BC[dt][ct]==0)
                {
                    h=TinhGTH(dt,ct);
            //        System.out.println("h= "+h+"\ndt = "+dt+"\nct = "+ct);
                    if(h<min)
                    {
                        min=h;
                        vtdm=dt;
                        vtcm=ct;
                        
                    }
                }
            }
            if(vtdm==-1 || vtcm==-1)
                return -1;  //false

    //    System.out.println("Position next : ("+vtdm+" , "+vtcm+")");
            xuat1oco(d, c, BC[d][c]);
            d=vtdm;
            c=vtcm;
            buoc++;
            BC[d][c]=buoc;

        }


        xuat1oco(d, c, BC[d][c]);

        return 1;//true
    }

    //intit board
    public void khoiTao()
    {
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                BC[i][j]=0;
    }

    //print broad
    public void XuatBC()
    {

        btn=new JButton[8][8];
        g=new GridLayout(8,8);
        this.setLayout(g);

        int d=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                d++;
                btn[i][j]=new JButton();

                if(i%2==0){
                    if(d%2==0){        

                        btn[i][j].setBackground(Color.WHITE);

                    }else
                    {

                        btn[i][j].setBackground(Color.GRAY);

                    }

                }else
                {
                    if(d%2==1){        

                    btn[i][j].setBackground(Color.WHITE);


                }else
                {

                    btn[i][j].setBackground(Color.GRAY);

                }

                }


                this.add(btn[i][j]);
//                
            }    
        } 


    }



    public void kiemtra(int dong,int cot)
    {
        if(maDiTuan(dong,cot)==-1)
        
        
    {
        JOptionPane.showMessageDialog(null, "False");

    }
    else
    {
        JOptionPane.showMessageDialog(null, "Success");

    }
}

    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
    	KinghtsTour n=new KinghtsTour();
        n.setVisible(true);                
        while (true) {
            if(MaDT.INIT_X==-1||MaDT.INIT_Y==-1)
            {
                System.out.println("wait...");
            }
            else
            {
                System.out.println("break");
                break;
            }
        }
        n.kiemtra(MaDT.INIT_X,MaDT.INIT_Y);
    }

}