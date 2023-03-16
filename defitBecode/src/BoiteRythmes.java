import javax.sound.midi.*;

public class BoiteRythmes {

    public static void main(String[] args) {
        try {
            // Créer une séquence et une piste MIDI
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            // Ajouter des notes à la piste MIDI
            int tempo = 60;
            for (int i = 0; i < 16; i++) {
                track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, 60, 100), i * 4));
                track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, 64, 100), i * 4 + 2));
                track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, 60, 100), i * 4 + 4));
                track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, 64, 100), i * 4 + 4));
            }

            // Définir le tempo de la séquence
            sequencer.setTempoInBPM(tempo);

            // Jouer la séquence
            sequencer.setSequence(sequence);
            sequencer.start();

            // Attendre la fin de la séquence
            while (sequencer.isRunning()) {
                Thread.sleep(100);
            }

            // Fermer le séquenceur MIDI
            sequencer.stop();
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
