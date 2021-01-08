/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     22/02/2020
 *
 * A library to manipulate digital audio and create audio collages.
 *
 * We will represent sound as an array of real numbers between –1 and +1,
 * with 44,100 samples per second, and write a library of functions to
 * produce audio effects by manipulating such arrays.
 *
 * Amplify:
 * Create a new sound that contains the same samples as an existing sound,
 * but with each sample multiplied by a constant α. This increases the
 * volume when α>1 and decreases it when 0<α<1.
 *
 * Reverse:
 * Create a new sound that contains the same samples as an existing sound,
 * but in reverse order. This can lead to unexpected and entertaining results.
 *
 * Merge/join:
 * Create a new sound that combines two existing sounds by appending the
 * second one after the first. If the two sounds have m and n samples, then
 * the resulting sound has m + n samples. This enables you to play two sounds
 * sequentially.
 *
 * Mix/overlay:
 * Create a new sound that combines two existing sounds by summing the values
 * of the corresponding samples. If one sound is longer than the other,
 * append 0s to the shorter sound before summing. This enables you to play
 * two sounds simultaneously.
 *
 * Change speed:
 * Create a new sound that changes the duration of an existing sound via
 * resampling. If the existing sound has n samples, then the new sound
 * has ⌊n/α⌋ samples for some constant α>0, with sample i of the new sound
 * having the same amplitude as sample ⌊iα⌋ of the existing sound.
 *
 **************************************************************************** */

public class AudioCollage {


    // Returns a new array that rescales a[] by a multiplicative factor alpha
    public static double[] amplify(double[] a, double alpha) {

        double[] result = new double[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = alpha * a[i];
        }
        return result;
    }


    // Returns a new array that is the reverse of a[]
    public static double[] reverse(double[] a) {

        double[] result = new double[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[result.length - 1 - i];
        }
        return result;
    }


    // Returns a new array that is the concatenation of a[] and b[]
    public static double[] merge(double[] a, double[] b) {

        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = a.length; i < result.length; i++) {
            result[i] = b[i - a.length];
        }

        return result;
    }


    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        double[] result = new double[Integer.max(a.length, b.length)];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[i] += b[i];
        }
        return result;
    }


    public static double[] changeSpeed(double[] a, double alpha) {
        /*  Create a new sound that changes the duration of an existing sound
        via resampling.
        If the existing sound has n samples, then the new sound
        has (n / alpha) samples for constant alpha > 0, with sample i of the
        new sound having the same amplitude as sample alpha * i of the existing
        sound.
         */

        double[] result = new double[(int) (a.length / alpha)];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[(int) (alpha * i)];
        }

        return result;
    }


    // Normalizes the sound between –1 and +1
    private static double[] normalize(double[] a) {

        double[] result = new double[a.length];

        // Find the maximum value
        double max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }

        // Normalize
        if (max > 1) {
            for (int i = 0; i < a.length; i++) {
                result[i] = a[i] / max;
            }
            return result;
        }
        else return a;
    }


    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {

        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] scratch = StdAudio.read("scratch.wav");
        double[] silence = StdAudio.read("silence.wav");
        double[] singer = StdAudio.read("singer.wav");

        StdAudio.play(changeSpeed(amplify(silence, 0.1), 2));
        double[] temp = merge(reverse(beatbox), reverse(beatbox));
        temp = amplify(temp, 1.2);
        temp = amplify(merge(temp, piano), 0.3);
        temp = merge(temp, amplify(piano, 0.2));
        temp = mix(amplify(singer, 0.4), temp);
        temp = normalize(temp);
        StdAudio.play(merge(scratch, temp));
    }
}
