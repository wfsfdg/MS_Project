package com.example.msproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Integer;

public class dataInput extends AppCompatActivity {
    private AutoCompleteTextView writemenu;
    private EditText writeprice;
    List<String> searchList;
    AutoCompleteTextView autoCompleteTextView;
    private ImageView image;
    private Button imagebutton;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;
    public String locData = "";
    public String typeData = "";
    public String menuData = "";
    public String priceData = "";
    public String reviewData="";
    public byte[] imageData;
    public int selectedYear=0;
    public int selectedMonth=0;
    public int selectedDay=0;
    public int selectedHour=0;
    public int selectedMinute=0;
    public int DataPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datainput);
        AutoCompleteTextView menu = findViewById(R.id.menu);
        menuData = menu.getText().toString();
        EditText price = findViewById(R.id.price);
        priceData = price.getText().toString();
        EditText review = findViewById(R.id.review);

        image = findViewById(R.id.imageView);


        Intent getintent = getIntent();
        if (getintent != null) {
            selectedYear = getintent.getIntExtra("year", 0);
            selectedMonth = getintent.getIntExtra("month", 0);
            selectedDay = getintent.getIntExtra("dayOfMonth", 0);
            selectedHour = getintent.getIntExtra("hour", 0);
            selectedMinute = getintent.getIntExtra("minute", 0);

            TextView textView = findViewById(R.id.dateTime);

            LocalDateTime selectedDateTime = LocalDateTime.of(selectedYear, selectedMonth + 1,
                    selectedDay, selectedHour, selectedMinute);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 HH:mm");
            String formattedDateTime = selectedDateTime.format(formatter);
            textView.setText(formattedDateTime);

        }


        int defaultPosition = 0;
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.locs,
                android.R.layout.simple_spinner_item);//기본 스피너 레이아웃 사용
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //스피너 선택화면 기본 레이아웃 사용
        spinner.setAdapter(adapter);
        spinner.setSelection(defaultPosition);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedValue = parentView.getItemAtPosition(position).toString();
                locData = selectedValue;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.types,
                android.R.layout.simple_spinner_item);//기본 스피너 레이아웃 사용
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //스피너 선택화면 기본 레이아웃 사용
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(defaultPosition);//1번째 항목을 디폴트로 설정
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedValue = parentView.getItemAtPosition(position).toString();
                typeData = selectedValue;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // 선택된 항목의 값을 얻어오기
                String selectedValue = parentView.getItemAtPosition(position).toString();

                // 얻어온 값을 변수에 할당하거나 필요한 처리를 수행
                locData = selectedValue;

                // 이후 원하는 동작 수행
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // 아무것도 선택되지 않았을 때의 동작
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // 선택된 항목의 값을 얻어오기
                String selectedValue2 = parentView.getItemAtPosition(position).toString();

                // 얻어온 값을 변수에 할당하거나 필요한 처리를 수행
                typeData = selectedValue2;

                // 이후 원하는 동작 수행
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // 아무것도 선택되지 않았을 때의 동작
            }
        });


        searchList = new ArrayList<>();

        // 자동완성 단어 리스트에 세팅
        settingList();

        autoCompleteTextView = findViewById(R.id.menu);

        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, searchList));

        writemenu = findViewById(R.id.menu);
        writeprice = findViewById(R.id.price);

        writemenu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String inputText = editable.toString();
                menuData=inputText;
                String correspondingValue = getCorrespondingValue(inputText);
                writeprice.setText(correspondingValue);
                price.setText(correspondingValue);
                priceData = price.getText().toString();

            }
        });



        Button savebutton = findViewById(R.id.button2);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("error",priceData);
                reviewData = review.getText().toString();
                if (typeData.equals("식사"))
                {
                    if(priceData==""||menuData==""||reviewData==""||imageData==null) {

                        Toast.makeText(dataInput.this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        priceData = price.getText().toString();
                        DataPrice=Integer.valueOf(priceData);
                        String mealkey=String.format("%04d%02d%02d%02d%02d",selectedYear,selectedMonth+1,selectedDay,selectedHour,selectedMinute);
                        SharedPreference.putMealName(dataInput.this,mealkey,menuData);
                        SharedPreference.putMealYear(dataInput.this,mealkey,selectedYear);
                        SharedPreference.putMealMonth(dataInput.this,mealkey,selectedMonth);
                        SharedPreference.putMealDay(dataInput.this,mealkey,selectedDay);
                        SharedPreference.putMealHour(dataInput.this,mealkey,selectedHour);
                        SharedPreference.putMealMinute(dataInput.this,mealkey,selectedMinute);
                        SharedPreference.putMealType(dataInput.this,mealkey,typeData);
                        int KcalData=new Random().nextInt(200)+500;
                        SharedPreference.putMealKcal(dataInput.this,mealkey,KcalData);
                        SharedPreference.putMealPrice(dataInput.this,mealkey,DataPrice);
                        SharedPreference.putMealReview(dataInput.this,mealkey,reviewData);
                        SharedPreference.putMealLoc(dataInput.this,mealkey,locData);
                        SharedPreference.putMealImage(dataInput.this,mealkey,imageData);
                        Toast.makeText(dataInput.this, "저장 완료", Toast.LENGTH_SHORT).show();

                    }
                }
                else if(typeData.equals("음료"))
                {
                    if(priceData==""||menuData==""||reviewData=="") {

                        Toast.makeText(dataInput.this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        priceData = price.getText().toString();
                        DataPrice=Integer.valueOf(priceData);
                        String drinkkey=String.format("%04d%02d%02d%02d%02d",selectedYear,selectedMonth+1,selectedDay,selectedHour,selectedMinute);
                        SharedPreference.putDrinkName(dataInput.this,drinkkey,menuData);
                        SharedPreference.putDrinkYear(dataInput.this,drinkkey,selectedYear);
                        SharedPreference.putDrinkMonth(dataInput.this,drinkkey,selectedMonth);
                        SharedPreference.putDrinkDay(dataInput.this,drinkkey,selectedDay);
                        SharedPreference.putDrinkHour(dataInput.this,drinkkey,selectedHour);
                        SharedPreference.putDrinkMinute(dataInput.this,drinkkey,selectedMinute);
                        SharedPreference.putDrinkType(dataInput.this,drinkkey,typeData);
                        int KcalData=new Random().nextInt(200)+500;
                        SharedPreference.putDrinkKcal(dataInput.this,drinkkey,KcalData);
                        SharedPreference.putDrinkPrice(dataInput.this,drinkkey,DataPrice);
                        SharedPreference.putDrinkReview(dataInput.this,drinkkey,reviewData);
                        SharedPreference.putDrinkLoc(dataInput.this,drinkkey,locData);
                        SharedPreference.putDrinkImage(dataInput.this,drinkkey,imageData);
                        Toast.makeText(dataInput.this, "저장 완료", Toast.LENGTH_SHORT).show();
                    }}
                else {
                    Log.d("error", typeData);
                }
            }
        });
        //여기서부터 이미지 업로드 처리


        imagebutton = findViewById(R.id.image_button);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageSourceDialog();
            }
        });
    }

    private void showImageSourceDialog() {
        String[] options = {"카메라", "갤러리"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("이미지 선택");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        dispatchTakePictureIntent();
                        break;
                    case 1:
                        dispatchPickImageIntent();
                        break;
                }
            }
        });
        builder.show();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void dispatchPickImageIntent() {
        Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImageIntent, REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    if (imageBitmap != null && image != null) {
                        image.setImageBitmap(imageBitmap);
                        imageData = getBytesFromBitmap(imageBitmap);
                    }
                    else
                    {
                        Toast.makeText(dataInput.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (requestCode == REQUEST_IMAGE_PICK) {
                // 갤러리에서 선택한 이미지 처리
                Uri selectedImage = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    if (bitmap != null && image != null) {
                        image.setImageBitmap(bitmap);
                        imageData = getBytesFromBitmap(bitmap);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
    //이미지 업로드 처리 완료

    private String getCorrespondingValue(String inputText) {
        if ("수육국밥".equals(inputText)) {
            return "5800";
        } else if ("순대국밥".equals(inputText)) {
            return "5800";
        } else if ("얼큰국밥".equals(inputText)) {
            return "6300";
        } else if ("철판돈가스".equals(inputText)) {
            return "6800";
        } else if ("삼겹살김치철판".equals(inputText)) {
            return "5500";
        } else if ("치즈불닭철판".equals(inputText)) {
            return "5800";
        } else if ("데리야끼치킨솥밥".equals(inputText)) {
            return "5000";
        } else if ("숯불삼겹솥밥".equals(inputText)) {
            return "5000";
        } else if ("콘치즈솥밥".equals(inputText)) {
            return "5000";
        } else if ("우삼겹솥밥".equals(inputText)) {
            return "6000";
        } else if ("꼬치어묵우동".equals(inputText)) {
            return "5000";
        } else if ("왕새우튀김우동".equals(inputText)) {
            return "5500";
        } else if ("얼큰김치우동".equals(inputText)) {
            return "5500";
        } else if ("우동*돈가스set".equals(inputText)) {
            return "6500";
        } else if ("우동*알밥set".equals(inputText)) {
            return "6500";
        } else if ("계란라면".equals(inputText)) {
            return "3800";
        } else if ("치즈라면".equals(inputText)) {
            return "4000";
        } else if ("해장라면".equals(inputText)) {
            return "4000";
        } else if ("추억의도시락".equals(inputText)) {
            return "4000";
        } else if ("공기밥".equals(inputText)) {
            return "1000";
        } else if ("비비고찐만두".equals(inputText)) {
            return "2800";
        } else if ("라볶이".equals(inputText)) {
            return "4500";
        } else if ("떡순이".equals(inputText)) {
            return "5500";
        }


        return ""; // 또는 다른 값을 반환
    }

    //자동완성 리스트에 있는 메뉴 선택시 가격 자동입력
    private void settingList() {
        searchList.add("철판돈가스");
        searchList.add("삼겹살김치철판");
        searchList.add("치즈불닭철판");
        searchList.add("데리야끼치킨솥밥");
        searchList.add("숯불삼겹솥밥");
        searchList.add("콘치즈솥밥");
        searchList.add("우삼겹솥밥");
        searchList.add("꼬치어묵우동");
        searchList.add("왕새우튀김우동");
        searchList.add("얼큰김치우동");
        searchList.add("우동*돈가스set");
        searchList.add("우동*알밥set");
        searchList.add("계란라면");
        searchList.add("치즈라면");
        searchList.add("해장라면");
        searchList.add("추억의도시락");
        searchList.add("공기밥");
        searchList.add("비비고찐만두");
        searchList.add("라볶이");
        searchList.add("떡순이");
        searchList.add("수육국밥");
        searchList.add("순대국밥");
        searchList.add("얼큰국밥");
    }
    //메뉴 입력시 자동완성 리스트 스피너로 출력

}