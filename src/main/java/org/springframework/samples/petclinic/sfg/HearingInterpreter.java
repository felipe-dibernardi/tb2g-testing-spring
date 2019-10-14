package org.springframework.samples.petclinic.sfg;

import org.springframework.stereotype.Service;

/**
 * Classe HearingInterpreter
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
@Service
public class HearingInterpreter {

    private final WordProducer wordProducer;

    public HearingInterpreter(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    public String whatIHeard() {
        String word = wordProducer.getWord();
        System.out.println(word);
        return word;
    }
}
