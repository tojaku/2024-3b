/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.obskc.niop.bazapodataka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class SubmitEssayPanel extends javax.swing.JPanel {

    /**
     * Creates new form SubmitEssayPanel
     */
    public SubmitEssayPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        subjectLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        subjectComboBox = new javax.swing.JComboBox<>();
        teacherLabel = new javax.swing.JLabel();
        teacherTextField = new javax.swing.JTextField();

        topLabel.setBackground(new java.awt.Color(255, 255, 153));
        topLabel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        topLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topLabel.setText("Prijava završnog rada");
        topLabel.setOpaque(true);

        titleLabel.setText("Naslov");

        subjectLabel.setText("Predmet");

        confirmButton.setBackground(new java.awt.Color(204, 255, 153));
        confirmButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        confirmButton.setText("Potvrdi");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tehničko i poslovno komuniciranje", "Konfiguriranje računalnih mreža", "Sigurnost informacijskih sustava", "Ugradbeni računalni sustavi", "Skriptni jezici i Web programiranje", "Napredno i objektno programiranje", "Programiranje mobilnih uređaja", "Dijagnostika i održavanje ISa", "Poslužiteljski operacijski sustavi", "Web dizajn" }));

        teacherLabel.setText("Nastavnik");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(subjectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(teacherLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleTextField)
                            .addComponent(subjectComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(teacherTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherLabel)
                    .addComponent(teacherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        String title = titleTextField.getText();
        String subject = subjectComboBox.getSelectedItem().toString();
        String teacher = teacherTextField.getText();

        if ((title.isEmpty() && title.length() < 3)
                || (subject.isEmpty() && subject.length() < 3)
                || (teacher.isEmpty() && teacher.length() < 3)) {
            JOptionPane.showMessageDialog(this, "Provjerite unesene podatke i pokušajte ponovno.", "Greška unosa", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = Start.USER;

        try {
            Connection conn = Database.getInstance().getConnection();
            String query = "INSERT INTO submissions (title, subject, teacher, time, userId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, subject);
            stmt.setString(3, teacher);
            stmt.setString(4, LocalDateTime.now().toString());
            stmt.setLong(5, user.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Prijava završnog rada zaprimljena.", "Uspjeh", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.err.println("Greška prilikom spremanja prijave završnog rada u bazu!");
            JOptionPane.showMessageDialog(this, "Prijava završnog rada se nije pohranila u bazu podataka.", "Greška prijave", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> subjectComboBox;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JLabel teacherLabel;
    private javax.swing.JTextField teacherTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JLabel topLabel;
    // End of variables declaration//GEN-END:variables
}
