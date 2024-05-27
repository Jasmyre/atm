import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class App {

  public static HashMap<Integer, Integer> pinInfo = new HashMap<Integer, Integer>();
  public static HashMap<Integer, String> nameInfo = new HashMap<Integer, String>();
  public static HashMap<Integer, Integer> balanceInfo = new HashMap<Integer, Integer>();
  public static ArrayList<Integer> usedCardNumbers = new ArrayList<Integer>();

  public static String rootPath = URLDecoder.decode(new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath(), StandardCharsets.UTF_8);


  public static boolean fullScreen = false;

  public static class WithdrawGUI implements ActionListener {
    JFrame frame = new JFrame("Withdraw");

    JPanel innerPanel = new JPanel();

    JPanel header = new JPanel();
    JPanel headerDiv1 = new JPanel();
    JPanel headerDiv2 = new JPanel();
    JPanel headerDiv3 = new JPanel();

    JLabel logo = new JLabel("A.T.M");

    JButton headerBackBtn = new JButton("Back");

    JPanel panel = new JPanel();
    JLabel withdrawIcon = new JLabel(new ImageIcon(new ImageIcon(rootPath + ".\\img\\withdraw1.png").getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
    JLabel withAmountLabel = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Amount:</h3></html>");
    JTextField withAmount = new JTextField();
    JButton confirmBtn = new JButton("confirm");
    JLabel withdrawHeader = new JLabel("<html><h1 style='font-weight; bold;'>Withdraw</h1></html>");

    GridBagConstraints gbc = new GridBagConstraints();

    String userName;
    int userBalance;

    WithdrawGUI(String paramUserName, int paramUserBalance) {
        userName = paramUserName;
        userBalance = paramUserBalance;

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(750, 500);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      if (fullScreen) {
          
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      }

        header.setLayout(new BorderLayout());
        header.setBackground(new Color(0x1ebdff));
        header.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));

        headerDiv1.setLayout(new GridBagLayout());
        headerDiv1.setBackground(new Color(0x1ebdff));
        headerDiv2.setLayout(new GridBagLayout());
        headerDiv2.setBackground(new Color(0x1ebdff));
        headerDiv3.setLayout(new GridBagLayout());
        headerDiv3.setBackground(new Color(0x1ebdff));

        gbc.gridx = 0;
        gbc.gridy = 0;
        logo.setForeground(new Color(0x000000));
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        headerDiv1.add(logo, gbc);

        gbc.gridx= 0;
        gbc.gridy = 0;
        headerDiv2.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        headerBackBtn.setFocusable(false);
        headerBackBtn.setPreferredSize(new Dimension(96, 32));
        headerBackBtn.addActionListener(this);
        headerBackBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        headerBackBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        headerBackBtn.setBackground(new Color(0x019bfe));
        headerBackBtn.setForeground(new Color(0xfcfcfc));
        headerBackBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        headerBackBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    headerBackBtn.setBackground(new Color(0x2177de));
                    headerBackBtn.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    headerBackBtn.setBackground(new Color(0x019bfe));
                    headerBackBtn.setForeground(new Color(0xfcfcfc));
                }
            });
        headerDiv3.add(headerBackBtn, gbc);

        header.add(headerDiv1, BorderLayout.WEST);
        header.add(headerDiv2, BorderLayout.CENTER);
        header.add(headerDiv3, BorderLayout.EAST);

        panel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(8, 8, 8, 8);

        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(header, BorderLayout.NORTH);
        innerPanel.add(panel, BorderLayout.CENTER);
        innerPanel.setBackground(new Color(0xedebeb));

        panel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(withdrawHeader, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(withdrawIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(withAmountLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        withAmount.setColumns(20);
        withAmount.setPreferredSize(new Dimension(0, 32));
        panel.add(withAmount, gbc);
        panel.setBackground(new Color(0x1ebdff));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(24, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        confirmBtn.setFocusable(false);
        confirmBtn.addActionListener(this);
        confirmBtn.setPreferredSize(new Dimension(96, 32));
        confirmBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        confirmBtn.setBackground(new Color(0x019bfe));
        confirmBtn.setForeground(new Color(0xfcfcfc));
        confirmBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        confirmBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    confirmBtn.setBackground(new Color(0x2177de));
                    confirmBtn.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    confirmBtn.setBackground(new Color(0x019bfe));
                    confirmBtn.setForeground(new Color(0xfcfcfc));
                }
            });
        panel.add(confirmBtn, gbc);
        frame.add(innerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(confirmBtn)) {
        int userWithdrawAmount = Integer.parseInt(withAmount.getText());

        if (userWithdrawAmount > 0 && (userBalance - userWithdrawAmount) >= 0) {
            userBalance = userBalance - userWithdrawAmount;

            JOptionPane.showMessageDialog(null, "Withdraw Successful!");

            frame.dispose();
            new HomeGUI(userName, userBalance);
        } else if (userBalance - userWithdrawAmount < 0) {
            JOptionPane.showMessageDialog(null, "Cannot Withdraw. Not Enough Balance!");
            withAmount.setText("");
        }
      } else if (e.getSource().equals(headerBackBtn)) {
        frame.dispose();
        new HomeGUI(userName, userBalance);
      }
    }
  }

  public static class DepositGUI implements ActionListener {
    JFrame frame = new JFrame("Deposit");

    JPanel innerPanel = new JPanel();

    JPanel header = new JPanel();
    JPanel headerDiv1 = new JPanel();
    JPanel headerDiv2 = new JPanel();
    JPanel headerDiv3 = new JPanel();

    JLabel logo = new JLabel("A.T.M");

    JButton headerBackBtn = new JButton("Back");

    JLabel depositIcon = new JLabel(new ImageIcon(new ImageIcon(rootPath + ".\\img\\deposit1.png").getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
    JPanel panel = new JPanel();
    JTextField depoAmount = new JTextField();
    JLabel depoAmountLabel = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Amount:</h3></html>");
    JButton confirmBtn = new JButton("confirm");
    JLabel depositHeader = new JLabel("<html><h1 style='font-weight; bold;'>Deposit</h1></html>");

    GridBagConstraints gbc = new GridBagConstraints();

    String userName;
    int userBalance;

    DepositGUI(String paramUserName, int paramUserBalance) {
        userName = paramUserName;
        userBalance = paramUserBalance;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        panel.setBackground(new Color(0x1ebdff));
        if (fullScreen) {
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        header.setLayout(new BorderLayout());
        header.setBackground(new Color(0x1ebdff));
        header.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));

        headerDiv1.setLayout(new GridBagLayout());
        headerDiv1.setBackground(new Color(0x1ebdff));
        headerDiv2.setLayout(new GridBagLayout());
        headerDiv2.setBackground(new Color(0x1ebdff));
        headerDiv3.setLayout(new GridBagLayout());
        headerDiv3.setBackground(new Color(0x1ebdff));

        gbc.gridx = 0;
        gbc.gridy = 0;
        logo.setForeground(new Color(0x000000));
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        headerDiv1.add(logo, gbc);

        gbc.gridx= 0;
        gbc.gridy = 0;
        headerDiv2.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        headerBackBtn.setFocusable(false);
        headerBackBtn.setPreferredSize(new Dimension(96, 32));
        headerBackBtn.addActionListener(this);
        headerBackBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        headerBackBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        headerBackBtn.setBackground(new Color(0x019bfe));
        headerBackBtn.setForeground(new Color(0xfcfcfc));
        headerBackBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        headerBackBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    headerBackBtn.setBackground(new Color(0x2177de));
                    headerBackBtn.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    headerBackBtn.setBackground(new Color(0x019bfe));
                    headerBackBtn.setForeground(new Color(0xfcfcfc));
                }
            });
        headerDiv3.add(headerBackBtn, gbc);

        header.add(headerDiv1, BorderLayout.WEST);
        header.add(headerDiv2, BorderLayout.CENTER);
        header.add(headerDiv3, BorderLayout.EAST);

        panel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(8, 8, 8, 8);

        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(header, BorderLayout.NORTH);
        innerPanel.add(panel, BorderLayout.CENTER);
        innerPanel.setBackground(new Color(0xedebeb));

        panel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(depositHeader, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        depositIcon.setBackground(Color.black);
        panel.add(depositIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(depoAmountLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        depoAmount.setColumns(20);
        depoAmount.setPreferredSize(new Dimension(0, 32));
        panel.add(depoAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(24, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        confirmBtn.setFocusable(false);
        confirmBtn.addActionListener(this);
        confirmBtn.setPreferredSize(new Dimension(96, 32));
        confirmBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        confirmBtn.setBackground(new Color(0x019bfe));
        confirmBtn.setForeground(new Color(0xfcfcfc));
        confirmBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        confirmBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                        confirmBtn.setBackground(new Color(0x2177de));
                        confirmBtn.setForeground(new Color(0xfcfcfc));
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        confirmBtn.setBackground(new Color(0x019bfe));
                        confirmBtn.setForeground(new Color(0xfcfcfc));
                    }
                });
        panel.add(confirmBtn, gbc);

        frame.add(innerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    int userBalanceCopy;
    public void addBalance(int amount) {
      userBalanceCopy = userBalanceCopy + amount;
      userBalance = userBalance + userBalanceCopy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(confirmBtn)) {
        int userDepoAmount = Integer.parseInt(depoAmount.getText());

        if (userDepoAmount > 0) {
          addBalance(userDepoAmount);
            
            JOptionPane.showMessageDialog(null, "Deposit Successfull!");
            
            frame.dispose();
            new HomeGUI(userName, userBalance);
        }
      } else if (e.getSource().equals(headerBackBtn)) {
        frame.dispose();
        new HomeGUI(userName, userBalance);
      }
    }
  }

  public static class BalanceGUI implements ActionListener {
    JFrame frame = new JFrame("Balance");

    JPanel innerPanel = new JPanel();

    JPanel header = new JPanel();
    JPanel headerDiv1 = new JPanel();
    JPanel headerDiv2 = new JPanel();
    JPanel headerDiv3 = new JPanel();

    JLabel logo = new JLabel("A.T.M");

    JButton headerBackBtn = new JButton("Back");

    JLabel balanceIcon = new JLabel(new ImageIcon(new ImageIcon(rootPath + ".\\img\\balance1.png").getImage().getScaledInstance(350, 225, Image.SCALE_SMOOTH)));
    JPanel panel = new JPanel();
    JButton backBtn = new JButton("Back");
    JButton logoutBtn = new JButton("log out.");
    JLabel balanceHeader = new JLabel("<html><h1 style='font-weight; bold;'>Balance</h1></html>");

    GridBagConstraints gbc = new GridBagConstraints();

    int userBalance;
    String userName;
    
    BalanceGUI(String paramUserName, int paramUserBalance) {
        userName = paramUserName;
        userBalance = paramUserBalance;

        JLabel userNameText = new JLabel("Name:");
        JLabel balanceText = new JLabel("Balance:");

        JLabel userNameBox = new JLabel(userName);
        JLabel balanceBox = new JLabel(String.valueOf(userBalance));

        userNameBox.setForeground(new Color(0xffffff));
        userNameBox.setFont(new Font("Arial", Font.BOLD, 12));
        userNameBox.setBackground(new Color(0x019bfe));
        userNameBox.setForeground(Color.white);
        userNameBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0), 2), BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        balanceBox.setForeground(new Color(0xfcfcfc));
        balanceBox.setFont(new Font("Arial", Font.BOLD, 12));
        balanceBox.setBackground(new Color(0x019bfe));
        balanceBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0), 2), BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        panel.setBackground(new Color(0x1ebdff));
        if (fullScreen) {
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        header.setLayout(new BorderLayout());
        header.setBackground(new Color(0x1ebdff));
        header.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));

        headerDiv1.setLayout(new GridBagLayout());
        headerDiv1.setBackground(new Color(0x1ebdff));
        headerDiv2.setLayout(new GridBagLayout());
        headerDiv2.setBackground(new Color(0x1ebdff));
        headerDiv3.setLayout(new GridBagLayout());
        headerDiv3.setBackground(new Color(0x1ebdff));

        gbc.gridx = 0;
        gbc.gridy = 0;
        logo.setForeground(new Color(0x000000));
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        headerDiv1.add(logo, gbc);

        gbc.gridx= 0;
        gbc.gridy = 0;
        headerDiv2.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        headerBackBtn.setFocusable(false);
        headerBackBtn.setPreferredSize(new Dimension(96, 32));
        headerBackBtn.addActionListener(this);
        headerBackBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        headerBackBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        headerBackBtn.setBackground(new Color(0x019bfe));
        headerBackBtn.setForeground(new Color(0xfcfcfc));
        headerBackBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        headerBackBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    headerBackBtn.setBackground(new Color(0x2177de));
                    headerBackBtn.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    headerBackBtn.setBackground(new Color(0x019bfe));
                    headerBackBtn.setForeground(new Color(0xfcfcfc));
                }
            });
        headerDiv3.add(headerBackBtn, gbc);

        header.add(headerDiv1, BorderLayout.WEST);
        header.add(headerDiv2, BorderLayout.CENTER);
        header.add(headerDiv3, BorderLayout.EAST);

        panel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(8, 8, 8, 8);

        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(header, BorderLayout.NORTH);
        innerPanel.add(panel, BorderLayout.CENTER);
        innerPanel.setBackground(new Color(0xedebeb));

        panel.setLayout(new GridBagLayout());

        if (fullScreen) {
          gbc.gridx = 0;
          gbc.gridy = 0;
          if (fullScreen) {gbc.gridy = 0;}
          panel.add(balanceHeader, gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        if (fullScreen) {gbc.gridy = 1;}
        panel.add(balanceIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        if (fullScreen) {gbc.gridy = 2;}
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(16, 0, 0, 0);
        userNameText.setForeground(new Color(0x6e6e6e));
        userNameText.setFont(new Font("Arial", Font.BOLD, 16));
        userNameText.setPreferredSize(new Dimension(200, 16));
        panel.add(userNameText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        if (fullScreen) {gbc.gridy = 3;}
        gbc.insets = new Insets(0, 0, 0, 0);
        userNameBox.setPreferredSize(new Dimension(200, 32));
        userNameBox.setForeground(new Color(0xffffff));
        userNameBox.setOpaque(true);
        panel.add(userNameBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        if (fullScreen) {gbc.gridy = 4;}
        gbc.insets = new Insets(16, 0, 0, 0);
        balanceText.setForeground(new Color(0x6e6e6e));
        balanceText.setFont(new Font("Arial", Font.BOLD, 16));
        balanceText.setPreferredSize(new Dimension(200, 16));
        panel.add(balanceText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        if (fullScreen) {gbc.gridy = 5;}
        gbc.insets = new Insets(0, 0, 0, 0);
        balanceBox.setPreferredSize(new Dimension(200, 32));
        balanceBox.setForeground(new Color(0xffffff));
        balanceBox.setOpaque(true);
        panel.add(balanceBox, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        if (fullScreen) {gbc.gridy = 6;}
        gbc.insets = new Insets(8, 0, 0, 0);
        logoutBtn.addActionListener(this);
        logoutBtn.setFocusable(false);
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        logoutBtn.setForeground(new Color(0x666666));
        logoutBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                        logoutBtn.setForeground(new Color(0x111111));
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        logoutBtn.setForeground(new Color(0x666666));
                    }
                });
        panel.add(logoutBtn, gbc);

        frame.add(innerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(headerBackBtn)) {
        new HomeGUI(userName, userBalance);
        frame.dispose();
      } else if (e.getSource().equals(logoutBtn)) {
        new IntroGUI();
        frame.dispose();
      }
    }
    
  }

  public static class HomeGUI implements ActionListener {
    JFrame frame = new JFrame("HOME");
    JLabel atnIcon = new JLabel(new ImageIcon(new ImageIcon(rootPath + ".\\img\\atm1.png").getImage().getScaledInstance(375,275, Image.SCALE_SMOOTH)));

    JPanel panel = new JPanel();
    JPanel innerPanel = new JPanel();

    JPanel header = new JPanel();
    JPanel headerDiv1 = new JPanel();
    JPanel headerDiv2 = new JPanel();
    JPanel headerDiv3 = new JPanel();

    JLabel logo = new JLabel("A.T.M");

    JButton balance = new JButton("Balance");
    JButton deposit = new JButton("Deposit");
    JButton withdraw = new JButton("Withdraw");

    GridBagConstraints gbc = new GridBagConstraints();
    
    String userName;
    int userBalance;

    HomeGUI(String paramUserName, int paramUserBalance) {

        userName = paramUserName;
        userBalance = paramUserBalance;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        //panel.setBackground(new Color(0x1ebdff));
        panel.add(atnIcon);
        if (fullScreen) {
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        header.setLayout(new BorderLayout());
        header.setBackground(new Color(0x1ebdff));
        header.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));

        headerDiv1.setLayout(new GridBagLayout());
        headerDiv1.setBackground(new Color(0x1ebdff));
        headerDiv2.setLayout(new GridBagLayout());
        headerDiv2.setBackground(new Color(0x1ebdff));
        headerDiv3.setLayout(new GridBagLayout());
        headerDiv3.setBackground(new Color(0x1ebdff)); 
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        logo.setForeground(new Color(0x000000));
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        headerDiv1.add(logo, gbc);

        gbc.gridx= 0;
        gbc.gridy = 0;
        headerDiv2.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 8, 0, 8);
        balance.setFocusable(false);
        balance.setPreferredSize(new Dimension(96, 32));
        balance.addActionListener(this);
        balance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        balance.setFont(new Font("Arial", Font.PLAIN, 12));
        balance.setBackground(new Color(0x019bfe));
        balance.setForeground(new Color(0xfcfcfc));
        balance.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        balance.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    balance.setBackground(new Color(0x2177de));
                    balance.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    balance.setBackground(new Color(0x019bfe));
                    balance.setForeground(new Color(0xfcfcfc));
                }
            });
        headerDiv3.add(balance, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        deposit.setFocusable(false);
        deposit.setPreferredSize(new Dimension(96, 32));
        deposit.addActionListener(this);
        deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deposit.setFont(new Font("Arial", Font.PLAIN, 12));
        deposit.setBackground(new Color(0x019bfe));
        deposit.setForeground(new Color(0xfcfcfc));
        deposit.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        deposit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    deposit.setBackground(new Color(0x2177de));
                    deposit.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    deposit.setBackground(new Color(0x019bfe));
                    deposit.setForeground(new Color(0xfcfcfc));
                }
            });
        headerDiv3.add(deposit, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        withdraw.setFocusable(false);
        withdraw.setPreferredSize(new Dimension(96, 32));
        withdraw.addActionListener(this);
        withdraw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        withdraw.setFont(new Font("Arial", Font.PLAIN, 12));
        withdraw.setBackground(new Color(0x019bfe));
        withdraw.setForeground(new Color(0xfcfcfc));
        withdraw.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        withdraw.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    withdraw.setBackground(new Color(0x2177de));
                    withdraw.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    withdraw.setBackground(new Color(0x019bfe));
                    withdraw.setForeground(new Color(0xfcfcfc));
                }
            });
        headerDiv3.add(withdraw, gbc);

        header.add(headerDiv1, BorderLayout.WEST);
        header.add(headerDiv2, BorderLayout.CENTER);
        header.add(headerDiv3, BorderLayout.EAST);

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(0x1ebdff));
        gbc.insets = new Insets(8, 8, 8, 8);

        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(header, BorderLayout.NORTH);
        innerPanel.add(panel, BorderLayout.CENTER);
        innerPanel.setBackground(new Color(0xedebeb));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(atnIcon);
        
        frame.add(innerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(balance)) {
        new BalanceGUI(userName, userBalance);
        frame.dispose();
      } else if (e.getSource().equals(deposit)) {
        new DepositGUI(userName, userBalance);
        frame.dispose();
      } else if (e.getSource().equals(withdraw)) {
        new WithdrawGUI(userName, userBalance);
        frame.dispose();
      }
    }
  }

  public static class SigninGUI implements ActionListener {
    JFrame frame = new JFrame("Sign In");
    JLabel signinHeader = new JLabel("<html><h1 style='font-weight; bold;'>Sign In</h1></html>");
    JTextField cardNumberInput = new JTextField();
    JPasswordField pinInput = new JPasswordField();
    JLabel numberPlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Card no.</h3></html>");
    JLabel pinPlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Pin no.</h3></html>");
    JButton signinBtn = new JButton("Continue →");
    JButton signupBtn = new JButton("sign up.");
    JPanel panel = new JPanel();
    JLabel pfp = new JLabel(new ImageIcon(new ImageIcon(rootPath + ".\\img\\default-pfp.png").getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH)));

    GridBagConstraints gbc = new GridBagConstraints();

    SigninGUI() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(750, 500);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      panel.setBackground(Color.cyan);
      if (fullScreen) {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      }

      panel.setLayout(new GridBagLayout());
      panel.setBackground(new Color(0xedebeb));

      gbc.gridx = 0;
      gbc.gridy = 0;
      panel.add(signinHeader, gbc);
      panel.setBackground(new Color(0x1ebdff));

      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(pfp, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      panel.add(numberPlaceholder, gbc);

      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.insets = new Insets(0, 0, 0, 0);
      cardNumberInput.setColumns(20);
      cardNumberInput.setPreferredSize(new Dimension(0, 32));
      cardNumberInput.setBackground(new Color(0xf9f9f9));
      cardNumberInput.addActionListener(this);
      panel.add(cardNumberInput, gbc);

      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(16, 0, 0, 0);
      panel.add(pinPlaceholder, gbc);

      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.insets = new Insets(0, 0, 0, 0);
      pinInput.setColumns(20);
      pinInput.setPreferredSize(new Dimension(0, 32));
      pinInput.addActionListener(this);
      panel.add(pinInput, gbc);

      gbc.gridx = 0;
      gbc.gridy = 6;
      gbc.fill = GridBagConstraints.NONE;
      gbc.insets = new Insets(40, 0, 0, 0);
      signinBtn.setFocusable(false);
      signinBtn.addActionListener(this);
      signinBtn.setPreferredSize(new Dimension(96, 32));
      signinBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      signinBtn.setFont(new Font("Arial", Font.PLAIN, 12));
      signinBtn.setBackground(new Color(0x019bfe));
      signinBtn.setForeground(new Color(0xfcfcfc));
      signinBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
      signinBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                signinBtn.setBackground(new Color(0x2177de));
                signinBtn.setForeground(new Color(0xfcfcfc));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                signinBtn.setBackground(new Color(0x019bfe));
                signinBtn.setForeground(new Color(0xfcfcfc));
            }
        });
      panel.add(signinBtn, gbc);

      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.insets = new Insets(8, 0, 0, 0);
      signupBtn.addActionListener(this);
      signupBtn.setFocusable(false);
      signupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      signupBtn.setContentAreaFilled(false);
      signupBtn.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      signupBtn.setForeground(new Color(0x666666));
      signupBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    signupBtn.setForeground(new Color(0x111111));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    signupBtn.setForeground(new Color(0x666666));
                }
            });
        panel.add(signupBtn, gbc);

      frame.add(panel, BorderLayout.CENTER);
      frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(signinBtn)) {
        int userCardNumber = Integer.parseInt(cardNumberInput.getText());
        int userPin = Integer.parseInt(String.valueOf(pinInput.getPassword()));
  
        if (pinInfo.containsKey(userCardNumber)) {
          if (pinInfo.get(userCardNumber).equals(userPin)) {
            String userName = nameInfo.get(userCardNumber);
            int userBalance = balanceInfo.get(userCardNumber);

            new HomeGUI(userName, userBalance);
            frame.dispose();
          } else {
            pinInput.setText("");
            cardNumberInput.setText("");
          }
        } else {
          pinInput.setText("");
          cardNumberInput.setText("");
        }
      } else if (e.getSource().equals(signupBtn)) {
        new SignupGUI();
        frame.dispose();
      }
    }
  }

  public static class SignupGUI implements ActionListener {
    JFrame frame = new JFrame("Sign Up");
    JLabel signupHeader = new JLabel("<html><h1 style='font-weight; bold;'>Sign Up</h1></html>");
    JTextField nameInput = new JTextField(20);
    JTextField cardNumberInput = new JTextField(20);
    JPasswordField pinInput = new JPasswordField(20);
    JLabel namePlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Name:</h3></html>");
    JLabel cardNumberPlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Card no.</h3></html>");
    JLabel pinPlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Pin no.</h3></html>");
    JButton signupBtn = new JButton("Register →");
    JButton signinBtn = new JButton("sign in.");
    JPanel panel = new JPanel();

    GridBagConstraints gbc = new GridBagConstraints();
    SignupGUI() {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        panel.setBackground(Color.cyan);
        if (fullScreen) {
          
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(0x1ebdff));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 24, 0);
        panel.add(signupHeader, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(16, 0, 0, 0);
        panel.add(namePlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        nameInput.setPreferredSize(new Dimension(0, 32));
        panel.add(nameInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(16, 0, 0, 0);
        panel.add(cardNumberPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        cardNumberInput.setPreferredSize(new Dimension(0, 32));
        panel.add(cardNumberInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(16, 0, 0, 0);
        panel.add(pinPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 0, 0);
        pinInput.setPreferredSize(new Dimension(0, 32));
        panel.add(pinInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(40, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        signupBtn.setFocusable(false);
        signupBtn.addActionListener(this);
        signupBtn.setPreferredSize(new Dimension(96, 32));
        signupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signupBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        signupBtn.setBackground(new Color(0x019bfe));
        signupBtn.setForeground(new Color(0xfcfcfc));
        signupBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
        signupBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    signupBtn.setBackground(new Color(0x2177de));
                    signupBtn.setForeground(new Color(0xfcfcfc));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    signupBtn.setBackground(new Color(0x019bfe));
                    signupBtn.setForeground(new Color(0xfcfcfc));
                }
            });
        panel.add(signupBtn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(8, 0, 0, 0);
        signinBtn.addActionListener(this);
        signinBtn.setFocusable(false);
        signinBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signinBtn.setContentAreaFilled(false);
        signinBtn.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        signinBtn.setForeground(new Color(0x666666));
        signinBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    signinBtn.setForeground(new Color(0x111111));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    signinBtn.setForeground(new Color(0x666666));
                }
            });
        panel.add(signinBtn, gbc);


        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signupBtn)) {
            if (nameInput.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is Required.");

            } else {
                if (cardNumberInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Card Number is Required.");

                } else {
                    if (String.valueOf(pinInput.getPassword()).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Pin is Required.");

                    } else {
                        String userName = nameInput.getText();
                        int userCardNumber = Integer.parseInt(cardNumberInput.getText());
                        int userPin = Integer.parseInt(String.valueOf(pinInput.getPassword()));

                        createUser(userCardNumber, userPin, userName, 0, frame);    
                        
                        cardNumberInput.setText("");
                        pinInput.setText("");
                    }
                }
            }
        } else if (e.getSource().equals(signinBtn)) {
          new SigninGUI();
          frame.dispose();
        }
    }
  }

  public static class IntroGUI implements ActionListener {
    JFrame frame = new JFrame("ATM");
    JPanel panel = new JPanel();
    JLabel atmIcon = new JLabel(new ImageIcon(new ImageIcon(rootPath + ".\\img\\intro.png").getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH)));
    JLabel atmHeader = new JLabel("<html><h1 style='font-weight; bold;'>Welcome!</h1></html>");
    JButton signupBtn = new JButton("Sign Up");
    JButton signinBtn = new JButton("Sign In");

    GridBagConstraints gbc = new GridBagConstraints();

    IntroGUI() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(750, 500);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());
      
      if (fullScreen) {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      }

      panel.setLayout(new GridBagLayout());
      panel.setBackground(new Color(0x1ebdff));

      gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(atmHeader, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.insets = new Insets(0, 0, 32, 0);
      panel.add(atmIcon, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(8, 8, 8, 8);
      signupBtn.setFocusable(false);
      signupBtn.setPreferredSize(new Dimension(0, 40));
      signupBtn.addActionListener(this);
      signupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      signupBtn.setFont(new Font("Arial", Font.PLAIN, 12));
      signupBtn.setBackground(new Color(0x019bfe));
      signupBtn.setForeground(new Color(0xfcfcfc));
      signupBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
      signupBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                signupBtn.setBackground(new Color(0x2177de));
                signupBtn.setForeground(new Color(0xfcfcfc));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                signupBtn.setBackground(new Color(0x019bfe));
                signupBtn.setForeground(new Color(0xfcfcfc));
            }
        });
      panel.add(signupBtn, gbc);

      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(8, 8, 8, 8);
      signinBtn.setFocusable(false);
      signinBtn.setPreferredSize(new Dimension(0, 40));
      signinBtn.addActionListener(this);
      signinBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      signinBtn.setFont(new Font("Arial", Font.PLAIN, 12));
      signinBtn.setBackground(new Color(0x019bfe));
      signinBtn.setForeground(new Color(0xfcfcfc));
      signinBtn.setBorder(BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(0x1B4965), 1, true), new javax.swing.border.EmptyBorder(5, 5, 5, 5)));
      signinBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                signinBtn.setBackground(new Color(0x2177de));
                signinBtn.setForeground(new Color(0xfcfcfc));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                signinBtn.setBackground(new Color(0x019bfe));
                signinBtn.setForeground(new Color(0xfcfcfc));
            }
        });
      panel.add(signinBtn, gbc);      
      
      frame.add(panel, BorderLayout.CENTER);
      frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signinBtn)) {
          new SigninGUI();
            frame.dispose();
        } else if (e.getSource().equals(signupBtn)) {
          new SignupGUI();
            frame.dispose();
        }
    }
  }

  public static void createUser(int createCardNumber, int createPin, String createName, int createBalance, JFrame frame) {
    if (!usedCardNumbers.contains(createCardNumber)) {

        usedCardNumbers.add(createCardNumber);

        pinInfo.put(createCardNumber, createPin);
        nameInfo.put(createCardNumber, createName);
        balanceInfo.put(createCardNumber, createBalance);
        
        if (frame != null) {
            JOptionPane.showMessageDialog(null, "Account Created Successfully!");

            new SigninGUI();
            frame.dispose();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Card Number Already Exist.");
    }
  }

  public static void setFullScreen(boolean paramBoolean) {
    fullScreen = paramBoolean;
  }

  public static void main(String[] args) {

    createUser(100, 100, "Jazmyre", 100, null);
    createUser(200, 200, "Talamisan", 200, null);
    createUser(300, 300, "Abujen", 300, null);
    createUser(400, 400, "Quebic", 400, null);
    createUser(500, 500, "Viola", 500, null);
    createUser(600, 600, "Riego", 600, null);
    createUser(700, 700, "Ocampo", 700, null);
    createUser(123, 456, "SpongeBob", 0, null);

    System.out.println(rootPath);
    System.out.println(new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
    System.out.println(URLDecoder.decode(new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath(), StandardCharsets.UTF_8));

    new IntroGUI();

  }
}