package Spotify_java;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayerUI extends JFrame {
    private Clip audioClip;
    private boolean isPlaying = false;

    public MusicPlayerUI() {
        setTitle("Music Player");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Image related to the music
        JLabel musicImage = new JLabel();
        musicImage.setHorizontalAlignment(SwingConstants.CENTER);
        musicImage.setIcon(new ImageIcon("artwork.jpg")); // Replace with your image file
        add(musicImage, BorderLayout.CENTER);

        // Play and Pause buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");

        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load the audio file
        try {
            File audioFile = new File("audio.wav"); // Replace with your audio file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading audio file: " + e.getMessage());
            System.exit(1);
        }

        // Add ActionListener for Play button
        playButton.addActionListener(e -> {
            if (audioClip != null && !isPlaying) {
                audioClip.setFramePosition(0); // Start from the beginning if paused
                audioClip.start();
                isPlaying = true;
            }
        });

        // Add ActionListener for Pause button
        pauseButton.addActionListener(e -> {
            if (audioClip != null && isPlaying) {
                audioClip.stop();
                isPlaying = false;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicPlayerUI player = new MusicPlayerUI();
            player.setVisible(true);
        });
    }
}
