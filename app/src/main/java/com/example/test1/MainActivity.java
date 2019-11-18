package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

public class MainActivity extends AppCompatActivity
{
    int senddata_r;
    int senddata_g;
    int senddata_b;
    int brightdata;
    int tmp_senddata_r;
    int tmp_senddata_g;
    int tmp_senddata_b;

    //int brightdata;
    int OnOffCount=0;
    private BluetoothSPP bt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = new BluetoothSPP(this);

        if (!bt.isBluetoothAvailable())                                                             //블루투스 사용 불가
        {
            Toast.makeText(getApplicationContext(), "블루투스 사용 불가", Toast.LENGTH_SHORT).show();
            finish();
        }

        /*bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener()                      //아두이노 에서 넘어오는 데이터 수신
        {
            public void onDataReceived(byte[] data, String message)
            {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });*/

        bt.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener()            //연결됐을 때
        {
            public void onDeviceConnected(String name, String address)
            {
                Toast.makeText(getApplicationContext(), "연결됨 -> " + name + "\n" + address, Toast.LENGTH_SHORT).show();
            }

            public void onDeviceDisconnected()                                                      //연결해제
            {
                Toast.makeText(getApplicationContext(), "연결 해제", Toast.LENGTH_SHORT).show();
            }

            public void onDeviceConnectionFailed()                                                  //연결실패
            {
                Toast.makeText(getApplicationContext(), "연결 실패", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnConnect = findViewById(R.id.btnConnect);                                          //연결시도
        btnConnect.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (bt.getServiceState() == BluetoothState.STATE_CONNECTED)
                {
                    bt.disconnect();
                }
                else
                {
                    Intent intent_DeviceList = new Intent(getApplicationContext(), DeviceList.class);startActivityForResult(intent_DeviceList, BluetoothState.REQUEST_CONNECT_DEVICE);
                }
            }
        });



        Button btnsetting = findViewById(R.id.btnSetting);                                                //블루투스 서비스가 된 후
        btnsetting.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                bt.send(new byte[] {0, 0, 0}, false);
                Intent intent_setting = new Intent(MainActivity.this, SettingActivity.class);
                startActivityForResult(intent_setting, 3312);
            }
        });


    }

    public void onDestroy()
    {
        super.onDestroy();
        bt.stopService();                                                                           //블루투스 중지

    }

    public void onStart()
    {
        super.onStart();
        if (!bt.isBluetoothEnabled())
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, BluetoothState.REQUEST_ENABLE_BT);
        }
        else
        {
            if (!bt.isServiceAvailable())
            {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_OTHER);
                setup();
            }
        }
    }

    public void setup()
    {
        /*
        Button btnsetting = findViewById(R.id.btnSetting);                                                //블루투스 서비스가 된 후
        btnsetting.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                bt.send(new byte[] {0, 0, 0}, false);
                Intent intent_setting = new Intent(MainActivity.this, SettingActivity.class);
                startActivityForResult(intent_setting, 3312);
            }
        });*/

        Button btnswitch = findViewById(R.id.btnSwitch);
        btnswitch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                bt.send(new byte[] {(byte)senddata_r, (byte)senddata_g, (byte)senddata_b,(byte)brightdata}, false);

                senddata_r = 0;
                senddata_g = 0;
                senddata_b = 0;

                Toast.makeText(MainActivity.this,(byte)senddata_r + "\n" +(byte)senddata_g + "\n" + (byte)senddata_b, Toast.LENGTH_LONG ).show();
            }
        });

        Button btnbright = findViewById(R.id.btnBright);
        btnbright.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_setting_bright = new Intent(MainActivity.this, SettingBrightActivty.class);
                startActivityForResult(intent_setting_bright, 3313);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                bt.connect(data);
            }
        }
        else if (requestCode == BluetoothState.REQUEST_ENABLE_BT)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_OTHER);
                setup();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "블루 투스 연결 안됨.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        if(requestCode == 3312)
        {
            if(resultCode == RESULT_OK)
            {
                senddata_r = data.getIntExtra("data_r",0);
                senddata_g = data.getIntExtra("data_g",0);
                senddata_b = data.getIntExtra("data_b",0);
            }
        }

        if(requestCode == 3313)
        {
            if(resultCode == RESULT_OK)
            {
                brightdata = data.getIntExtra("brightNum",255);

                //bt.send(new byte[] {(byte)brightdata}, false);
            }
        }
    }
}