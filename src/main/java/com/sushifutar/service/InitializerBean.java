package com.sushifutar.service;

import com.sushifutar.model.Food;
import com.sushifutar.model.FoodCategory;
import com.sushifutar.model.FoodSubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(FoodService foodService) {


        // JAPANESE BURGERS

        Food tokantsuBurger = new Food("Tokantsu Burger", "szezámos hamburger zsemle, 20 dkg marhahús, cheedar sajt, paradicsom, jégsaláta, jégcsapretek, tonkatsu szósz, japán burgonyasalátával és wasabis majonézzel\n" +
                "allergének: A B C F G I", FoodCategory.JAPANESE_HAMBURGERS, null, 2980, "http://bambuszliget.emenu.hu/upload/2017_11/06/150999602370295280/tonkatsu_burger.png");
        foodService.saveFood(tokantsuBurger);

        Food sakeBurger = new Food("Sake Burger", "szezámos hamburger zsemle, grillezett lazac, cheedar sajt, tintahal tintás tészta, karamellizált hagyma, teriyaki szósz, japán burgonyasalátával és wasabis majonézzel\n" +
                "allergének: A B C F G I J", FoodCategory.JAPANESE_HAMBURGERS, null, 3490, "http://bambuszliget.emenu.hu/upload/2017_11/06/150999477258143814/sake_burger.png");
        foodService.saveFood(sakeBurger);

        Food torikatsuBurger = new Food("Torikatsu Burger", "szezámos hamburger zsemle, panírozott csirkemell tojással, hagymával, Tori Katsu módra, saláta, japán burgonyasalátával és wasabis majonézzel\n" +
                "allergének: A B C F G I", FoodCategory.JAPANESE_HAMBURGERS, null, 2980, "http://bambuszliget.emenu.hu/upload/2017_11/06/150999585146714056/tori_katsu_burger.png");
        foodService.saveFood(torikatsuBurger);

        Food ebikatsuBurger = new Food("Ebikatsu Burger", "szezámos hamburger zsemle, panírozott rák pogácsa, saláta, tonkatsu szósz, japán burgonyasalátával és wasabis majonézzel\n" +
                "allergének: A B F G I K", FoodCategory.JAPANESE_HAMBURGERS, null, 3490, "http://bambuszliget.emenu.hu/upload/2017_11/06/150999570012463798/ebi_burger.png");
        foodService.saveFood(ebikatsuBurger);

        // SUSHI - NIGIRI SUSHI

        Food japanTojasLepeny = new Food("Japan Tojaslepeny", "Allergének: B,J", FoodCategory.SUSHIS, FoodSubCategory.NIGIRI, 420, "http://bambuszliget.emenu.hu/upload/2015_02/09/142351461859428908/dscf0191_resize.jpg");
        foodService.saveFood(japanTojasLepeny);

        Food sparga = new Food("Sparga", "Allergének: nincs", FoodCategory.SUSHIS, FoodSubCategory.NIGIRI, 520, "http://bambuszliget.emenu.hu/upload/2015_02/09/142351469281902278/dscf0178_resize.jpg");
        foodService.saveFood(sparga);

        Food preseltRak = new Food("Preselt Rak", "Allergének: I,K", FoodCategory.SUSHIS, FoodSubCategory.NIGIRI, 420, "http://bambuszliget.emenu.hu/upload/2015_02/09/142351472552985829/dscf0177_resize.jpg");
        foodService.saveFood(preseltRak);

        Food tintaHal = new Food("Tintahal", "Allergének: I,J", FoodCategory.SUSHIS, FoodSubCategory.NIGIRI, 490, "http://bambuszliget.emenu.hu/upload/2015_02/09/142351479043127412/dscf0163_resize.jpg");
        foodService.saveFood(tintaHal);

        Food avokado = new Food("Avokado", "Allergének: nincs", FoodCategory.SUSHIS, FoodSubCategory.NIGIRI, 510, "http://bambuszliget.emenu.hu/upload/2015_02/09/142351483534993327/dscf0175_resize.jpg");
        foodService.saveFood(avokado);

        Food pacoltMakrela = new Food("Pacolt Makrela", "ház készítésű pác. Allergének: I,J", FoodCategory.SUSHIS, FoodSubCategory.NIGIRI, 520, "http://bambuszliget.emenu.hu/upload/2015_02/09/142351492136774805/dscf0166_resize.jpg");
        foodService.saveFood(pacoltMakrela);


    }
}
