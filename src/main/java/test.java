import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import nlp.NLP;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.hucompute.textimager.uima.type.Sentiment;

import java.util.Collection;

public class test {

    public static void main(String[] args){
        String text = "Dr. Marco Buschmann (FDP):\n" +
                "Herr Präsident! Meine sehr geehrten Kolleginnen und Kollegen! Die Fraktion der Freien Demokraten ist nicht nur Antragsteller, sondern steht auch hinter diesem Antrag, weil er das Parlament sachgemäß und schnell arbeitsfähig macht, so wie es die Umstände gebieten. Der Hauptausschuss ist ein sachgemäßes Instrument, um vollumfänglich in allen Themenbereichen vertieft beraten zu können.\n" +
                "Den Petitionsausschuss, den ja viele sozusagen als einen Ausschuss zweiter Ordnung ansehen,\n" +
                "halten wir für entscheidend wichtig, weil er seit der Aufklärung das Instrument ist, mit dem sich jeder Bürger an den Souverän wenden kann. Insofern ist es ein gutes demokratisches Zeichen, dass auch dieser Ausschuss schnell eingesetzt wird.\n" +
                "Der Ausschuss für Wahlprüfung, Immunität und Geschäftsordnung ist neben seiner ursprünglichen Funktion auch deshalb wichtig, weil wir eine ganze Reihe von Anliegen haben, unsere Geschäftsordnung zu modernisieren. Genau diese Dinge können dort sachgemäß beraten werden.\n" +
                "Ich wäre gerne bei diesen sachgemäßen Argumenten verblieben; aber wie schon die konstituierende Sitzung des Deutschen Bundestages wird auch diese erste reguläre Sitzung missbraucht, um dem Aufmerksamkeitsdefizit-Syndrom der SPD nachzukommen.\n" +
                "Herr Schneider, Sie konnten kaum das Wahlergebnis abwarten, um die Flinte feige ins Korn zu werfen,\n" +
                "und werfen uns nach über vier Wochen des Ringens, des Beratens und der Suche nach Kompromissen hier irgendetwas vor. Da müssen Sie selber lachen, und das tun Sie mit Recht. Das können Sie ja wahrlich nicht ernst meinen.\n" +
                "Insofern wäre es besser gewesen, Sie wären beim sachlichen Kern dieser Debatte geblieben.\n" +
                "Ich möchte hier noch eine Anmerkung machen, die ich für zentral wichtig halte – da gebe ich Ihnen in der Sache sogar recht –: Der Hauptausschuss kann nur ein Provisorium sein; das ist allen Beteiligten klar. Der Hauptausschuss ist ein gutes Instrument, wenn tatsächlich eine erfolgreiche Regierungsbildung absehbar ist. Was nicht gehen wird – das möchte ich hier betonen –, ist, dass hier über fünf, sechs, sieben oder sonst wie viele Monate mit diesem Provisorium gearbeitet wird. Denn die Fachausschüsse haben natürlich auch die Aufgabe, den Sachverstand einzubinden, der sich im gesamten Parlament, in allen Fraktionen widerspiegelt, um zu sachgemäßen Lösungen zu kommen. Insofern würde ich mir wünschen, dass wir, wenn möglicherweise eine erfolgreiche Regierungsbildung nicht abzusehen ist, zu einem Verfahren kommen, um Fachausschüsse einzusetzen. Auch hier ist in ungewöhnlichen Situationen neues Denken „out of the box“ gefragt. Dazu möchte ich alle anderen Fraktionen einladen.\n" +
                "Herzlichen Dank.\n" +
                "Präsident Dr. Wolfgang Schäuble:\n" +
                "Das Wort hat der Abgeordnete Korte, Die Linke.\n";
        NLP pip = new NLP();
        JCas testJcas = pip.analyse(text);


        Collection<Sentiment> sentiments = JCasUtil.select(testJcas, Sentiment.class);
        System.out.println(sentiments);

//        Collection<Sentence> sentences = JCasUtil.select(testJcas, Sentence.class);
//        System.out.println(sentences);
//        for (Sentence sentence : sentences) {
//            for (Sentiment sentiment : JCasUtil.selectCovered(Sentiment.class, sentence)) {
//                System.out.println(sentiment);
//            }
//        }
    }

}
