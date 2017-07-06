package services;

import java.util.ArrayList;
import java.util.List;

public class SeriesExpansion {

    public List<String> extractSerie(String string) {
        List<String> result = new ArrayList<>();
        int serieIni = string.indexOf("[");
        if (serieIni == -1) {
            result.add(string);
        } else {
            int serieEnd = string.indexOf("]");
             for (String item : this.expandSerie(string.substring(serieIni + 1, serieEnd))) {
                result.add(item);
            }
        }
        return result;
    }
    
    public String extractBase(String string){
        int serieIni = string.indexOf("[");
        if (serieIni == -1) {
            return string;
        } else {
           return string.substring(0, serieIni);
        }       
    }

    public List<String> expandSerie(String serie) {
        List<String> result = new ArrayList<>();
        String[] values = serie.split(",");
        for (String value : values) {
            String[] parts = value.split("-|:");
            if (parts.length == 1) {
                result.add(parts[0]);
            } else {
                int add = 1;
                if (parts.length == 3) {
                    add = Integer.parseInt(parts[2]);
                }
                for (int i = Integer.parseInt(parts[0]); i <= Integer.parseInt(parts[1]); i += add) {
                    result.add(String.valueOf(i));
                }
            }
        }
        return result;
    }

}
