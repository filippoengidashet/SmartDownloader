/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartdownloader.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import smartdownloader.downloader.DownloadManager;
import smartdownloader.downloader.model.DownloadItem;
import smartdownloader.downloader.model.DownloadListener;
import smartdownloader.downloader.model.DownloadProgress;
import smartdownloader.downloader.model.DownloadRequest;

/**
 *
 * @author filippo
 */
public class SmartDownloaderUI extends javax.swing.JFrame implements DownloadListener {

    private DefaultListModel<DownloadItem> linksModel;

    /**
     * Creates new form SmartDownloaderUI
     */
    public SmartDownloaderUI() {
        initComponents();

        DownloadManager.get().addListener(this);

        buttonControlDownload.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JToggleButton tb = (JToggleButton) e.getSource();

                boolean selected = tb.isSelected();

                if (selected) {
                    String path = destinationPath.getText();
                    boolean canStartDownloading = !path.isEmpty();
                    updateControlButtonState(canStartDownloading);
                    if (canStartDownloading) {
                        startDownloading();
                    }
                } else {
                    updateControlButtonState(false);
                    stopDownloading();
                }
            }
        });

        linksModel = new DefaultListModel<>();
        linkList.setModel(linksModel);
        linkList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {

                    int response = JOptionPane.showConfirmDialog(null, "Do you want to remove this entry?", "Delete",
                            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        DownloadItem di = (DownloadItem) evt.getSource();
                        linksModel.removeElement(di);
                        //DownloadManager.get().cancel(di.downloadId);
                    }
                }
                linkList.clearSelection();
            }
        });
    }

    private void updateControlButtonState(boolean selected) {
        if (selected) {
            buttonControlDownload.setText("Stop Downloading");
        } else {
            buttonControlDownload.setText("Start Downloading");
        }
        buttonControlDownload.setSelected(selected);
    }

    private void startDownloading() {
        DownloadManager.get().start();
    }

    private void stopDownloading() {

    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonAddLink = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        linkURL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        destinationPath = new javax.swing.JTextField();
        buttonBrowsePath = new javax.swing.JButton();
        buttonAddBulkLinks = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bulkLinks = new javax.swing.JTextField();
        bulkLinksDelimiter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        progressMonitor = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        linkList = new javax.swing.JList<>();
        buttonControlDownload = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAddLink.setText("Add");
        buttonAddLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddLinkActionPerformed(evt);
            }
        });

        jLabel1.setText("Link:");

        linkURL.setText("https://i.imgur.com/xineeuw.jpg");

        jLabel2.setText("Destination Folder:");

        buttonBrowsePath.setText("Browse");
        buttonBrowsePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowsePathActionPerformed(evt);
            }
        });

        buttonAddBulkLinks.setText("Add");
        buttonAddBulkLinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddBulkLinksActionPerformed(evt);
            }
        });

        jLabel3.setText("Bulk Links:");

        bulkLinksDelimiter.setText(",");

        jLabel4.setText("Delimiter");

        progressMonitor.setColumns(20);
        progressMonitor.setRows(5);
        progressMonitor.setEnabled(false);
        jScrollPane1.setViewportView(progressMonitor);

        jScrollPane2.setViewportView(linkList);

        buttonControlDownload.setText("Start Downloading");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linkURL, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddLink))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinationPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBrowsePath))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulkLinks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulkLinksDelimiter, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddBulkLinks))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonControlDownload))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(destinationPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBrowsePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(linkURL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(buttonAddLink)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAddBulkLinks)
                        .addComponent(bulkLinksDelimiter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(bulkLinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonControlDownload)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBrowsePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowsePathActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose destination directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            destinationPath.setText(path.endsWith("/") ? path : path + "/");
        }
    }//GEN-LAST:event_buttonBrowsePathActionPerformed

    private void buttonAddLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddLinkActionPerformed
        String link = linkURL.getText();
        String path = destinationPath.getText();
        if (!path.isEmpty() && !link.isEmpty()) {
            addDownloadLink(link, path);
        } else {
            showMessage("Please specify a link URL or destination path!");
        }
    }//GEN-LAST:event_buttonAddLinkActionPerformed

    private void addDownloadLink(String link, String path) {
        if(link.isEmpty()) return;
        DownloadRequest request = new DownloadRequest(link, path);
        long downloadId = DownloadManager.get().addRequest(new DownloadRequest(link, path));
        linksModel.addElement(new DownloadItem(request, downloadId));
    }

    private void buttonAddBulkLinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddBulkLinksActionPerformed
        String bulkLinksText = bulkLinks.getText();
        String path = destinationPath.getText();
        if (!path.isEmpty() && !bulkLinksText.isEmpty()) {

            String delimiter = bulkLinksDelimiter.getText();
            if (delimiter.isEmpty()) {
                showMessage("Please specify delimiter");
            } else {
                String[] links = bulkLinksText.split(delimiter);
                for (String link : links) {
                    addDownloadLink(link, path);
                }
            }
        } else {
            showMessage("Please specify a bulk url links or destination path!");
        }
    }//GEN-LAST:event_buttonAddBulkLinksActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bulkLinks;
    private javax.swing.JTextField bulkLinksDelimiter;
    private javax.swing.JButton buttonAddBulkLinks;
    private javax.swing.JButton buttonAddLink;
    private javax.swing.JButton buttonBrowsePath;
    private javax.swing.JToggleButton buttonControlDownload;
    private javax.swing.JTextField destinationPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<DownloadItem> linkList;
    private javax.swing.JTextField linkURL;
    private javax.swing.JTextArea progressMonitor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onStart(long downloadId) {
        progressMonitor.append("Started downloading .. " + downloadId + "\n");
    }

    @Override
    public void onProgress(long downloadId, DownloadProgress progress) {
        progressMonitor.append("Download " + downloadId + " progress  .. " + progress.progress + "%" + "\n");
    }

    @Override
    public void onComplete(long downloadId, boolean success) {
        progressMonitor.append("Completed downloading .. " + downloadId + " - SUCCESS -> " + success + "\n");

        int size = linksModel.size();

        for (int i = 0; i < size; i++) {
            if (linksModel.get(i).downloadId == downloadId) {
                linksModel.removeElementAt(i);
                break;
            }
        }

        if (linksModel.isEmpty()) {
            updateControlButtonState(false);
        }
    }
}
