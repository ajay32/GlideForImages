package ajaymehta.glideforimages;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class MainActivity extends AppCompatActivity {

    ImageView netImage, netImage2,netImage3,netImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        netImage = (ImageView) findViewById(R.id.iv_netimge);
        netImage2 = (ImageView) findViewById(R.id.iv_netimge2);
        netImage3 = (ImageView) findViewById(R.id.iv_netimge3);
        netImage4 = (ImageView) findViewById(R.id.iv_netimge4);



        //=======Dont forget to put the Internet permission in manifest otherwise glide will not work==// it will not show any error

       // SIimple Image
        Glide.with(this).load("http://www.wonderslist.com/wp-content/uploads/2015/10/Doutzen-Kroes-Most-Beautiful-Dutch-Woman.jpg").into(netImage);

       //Gif file .
        Glide.with(this).load("http://media3.giphy.com/media/kEKcOWl8RMLde/giphy.gif").into(netImage2);


        // glide with place holder..
        Glide
                .with( this )
                .load( "http://www.wonderslist.com/wp-content/uploads/2015/10/Doutzen-Kroes-Most-Beautiful-Dutch-Woman.jpg" )
                .placeholder( R.drawable.lillie ) // you can show spinner here..  // on which image will come ..till image is coming it will show place holder ..
                .error( R.drawable.lavery )          // if error ocur this image will show ..
                .into( netImage3 );



// glide with circular coreners..
        Glide.with(this).load("https://s-media-cache-ak0.pinimg.com/736x/05/1c/11/051c110d463b1c4afb11ca003a6237a3--nice-girl-beautiful-body.jpg")
                .bitmapTransform(new RoundedCornersTransformation(this, dpToPx(7), 0,    //here we giving px ...as radius
                        RoundedCornersTransformation.CornerType.TOP))   // curving from top
                .into(netImage4);




    }

    // our image size is in dp ..we want to change it corner from square to circular ..  .. new RoundCorenersTransformaton class from glide transformtion library take second parameter  as radius (in px) ..

    public  int dpToPx(int dp) {   // the amount of dp we want to make circular from corner ..we converting it in px n giving ablove
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }


}
