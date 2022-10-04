package es.uned.master.java.logactaesque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uned.master.java.logactaesque.model.DiceRoll;
import es.uned.master.java.logactaesque.model.Rollable;

@Controller
public class DiceController {

    @Autowired(required = true)
    private Rollable configDice;


    @GetMapping("/dice/roll")
    public @ResponseBody DiceRoll DiceRoll() {
        return DiceRoll.invoke(configDice.roll());
    }

}
