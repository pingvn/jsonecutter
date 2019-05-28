package jsone;

import datamodel.CityModel;
import org.json.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsoneParse  {
    private final static String JSONE_CITY_NAME = "name";
    private final static String JSONE_COUNTRY = "country";
    private final static String FILE_READ_PATCH = "citylist.json";
    private final static String FILE_WRITE_PATCH = "city.txt";

    public void parseJsone()throws IOException{
        JSONArray cityListJsone = new JSONArray(readJsoneFile(FILE_READ_PATCH));
        List<CityModel> cityList = new ArrayList<>();
        for(int i = 0; i < cityListJsone.length();i++){
            JSONObject cityJsone = cityListJsone.getJSONObject(i);
            CityModel city = new CityModel();
            city.setCityName(cityJsone.getString(JSONE_CITY_NAME));
            city.setCountry(cityJsone.getString(JSONE_COUNTRY));
            cityList.add(city);
        }
        writeFile(FILE_WRITE_PATCH,cityList);
    }

    private String readJsoneFile(String pathtofile)throws IOException{
        String stringBuf = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathtofile));
        while ((stringBuf = bufferedReader.readLine())!= null){
            stringBuilder.append(stringBuf);
        }
        return stringBuilder.toString();
    }

    private void writeFile(String pathToWrite,List<CityModel> cityList)throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToWrite));
        for(CityModel city: cityList){
            bufferedWriter.write(city.getCityName()+"::"+city.getCountry()+",,");
        }
    }
}

