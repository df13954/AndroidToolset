# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\software\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#something by android

-keep public class * extends android.app.Activity                               # 保持哪些类不被混淆
-keep public class * extends android.app.Application                            # 保持哪些类不被混淆
-keep public class * extends android.app.Service                                # 保持哪些类不被混淆
-keep public class * extends android.content.BroadcastReceiver                  # 保持哪些类不被混淆
-keep public class * extends android.content.ContentProvider                    # 保持哪些类不被混淆
-keep public class * extends android.app.backup.BackupAgentHelper               # 保持哪些类不被混淆
-keep public class * extends android.preference.Preference                      # 保持哪些类不被混淆
-keep public class com.android.vending.licensing.ILicensingService              # 保持哪些类不被混淆

#日志过滤
-assumenosideeffects class android.util.Log {
           public static boolean isLoggable(java.lang.String, int);
           public static int v(...);
           public static int i(...);
           public static int w(...);
           public static int d(...);
           public static int e(...);
}

#http相关
-dontnote android.net.http.*
-dontnote org.apache.commons.codec.**
-dontnote org.apache.http.**
-dontnote org.apache.commons.logging.**
-keep class org.apache.http.** { *; }

#Butter Knife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#v4
#-libraryjars   libs/android-support-v4.jar
-dontwarn android.support.v4.**
-keep class android.support.v4.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment


#json解析
##---------------Begin: proguard configuration for fastjson  ----------

#-keepnames class * implements java.io.Serializable
-keep public class * implements java.io.Serializable {
        public *;
}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#如果引用了v4或者v7包
-dontwarn android.support.**
-dontwarn com.alibaba.fastjson.**

-dontskipnonpubliclibraryclassmembers
-dontskipnonpubliclibraryclasses

#-libraryjars libs/fastjson.jar
-keep class com.alibaba.fastjson.** { *; }

-keepclassmembers class * {
public <methods>;
}

##---------------End: proguard configuration for fastjson  ----------


#融云im
-keepclassmembers class fqcn.of.javascript.interface.for.webview{
 public *;
 }
 -keepattributes Exceptions,InnerClasses
 -keepattributes Signature
 -keepattributes *Annotation*
 -keep class com.google.gson.examples.android.model.**{*;}
 -keep class **$Properties
 -dontwarn org.eclipse.jdt.annotation.**
#目前暂时无语音相关的，所以这个不需要
 #-libraryjars libs/agora-rtc-sdk.jar
 #-keep class io.agora.rtc.** {*;}

 -keep class io.rong.** {*;}
 -keep class * implements io.rong.imlib.model.MessageContent{*;}
 -dontwarn io.rong.push.**

 -dontnote com.xiaomi.**
 -dontnote com.huawei.android.pushagent.**
 -dontnote com.google.android.gms.gcm.**

 -dontnote io.rong.**
 -ignorewarnings



#支付宝
-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IAlixPay$Stub{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
-keep class com.alipay.sdk.app.PayTask{ public *;}
-keep class com.alipay.sdk.app.AuthTask{ public *;}

#-keep class public com.alipay.**{*;}
#-keep class public com.ta.utdit2.**{*;}
#-keep class public com.ut.device.**{*;}
#友盟
-dontwarn com.taobao.**
-dontwarn anet.channel.**
-dontwarn anetwork.channel.**
-dontwarn org.android.**
-dontwarn org.apache.thrift.**
-dontwarn com.xiaomi.**
-dontwarn com.huawei.**

-keepattributes *Annotation*

-keep class com.taobao.** {*;}
-keep class org.android.** {*;}
-keep class anet.channel.** {*;}
-keep class com.umeng.** {*;}
-keep class com.xiaomi.** {*;}
-keep class com.huawei.** {*;}
-keep class org.apache.thrift.** {*;}

-keep public class **.R$*{
   public static final int *;
}


#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable

# webview + js
-keepattributes *JavascriptInterface*
# keep 使用 webview 的类
-keepclassmembers class  com.kapokhealth.library.DiseasesDetailedActivity {
   public *;
}
# keep 使用 webview 的类的所有的内部类
-keepclassmembers  class  com.kapokhealth.library.DiseasesDetailedActivity$*{
    *;
}

# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet, int);
}

# 保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-dontnote **ILicensingService


-dontwarn com.google.code.**
-dontwarn  org.apache.**
-dontwarn  jp.wasabeef.recyclerview.**
-dontwarn  com.nostra13.universalimageloader.**
-dontwarn  org.acra.**

#wasabeef recyclerview
-keep class jp.wasabeef.recyclerview.** { *; }
-keepattributes Signature
#HTTP Legacy
-keep class org.apache.** { *; }
-keepattributes Signature
#Universal Image Loader
-keep class com.nostra13.universalimageloader.** { *; }
-keepattributes Signature
#Acra
-keep class org.acra.**  { *; }
-keepattributes Signature
#Support libraries
-keep class com.android.** { *; }
-keepattributes Signature





# Keep the annotations
-keepattributes *Annotation*


-allowaccessmodification
-keepattributes *Annotation*
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
-repackageclasses ''


-dontnote com.android.vending.licensing.ILicensingService

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Preserve all native method names and the names of their classes.
-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Preserve static fields of inner classes of R classes that might be accessed
# through introspection.
-keepclassmembers class **.R$* {
  public static <fields>;
}

# Preserve the special static methods that are required in all enumeration classes.
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep public class * {
    public protected *;
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
  }

#okio 的混淆处理
-dontwarn okio.**

#webview
-keep public class android.net.http.SslError
-keep public class android.webkit.WebViewClient

-dontwarn android.webkit.WebView
-dontwarn android.net.http.SslError
-dontwarn android.webkit.WebViewClient


#高德
#3D 地图

    -keep   class com.amap.api.mapcore.**{*;}
    -keep   class com.amap.api.maps.**{*;}
    -keep   class com.autonavi.amap.mapcore.*{*;}

 #   定位

   -keep class com.amap.api.location.**{*;}
   -keep class com.amap.api.fence.**{*;}
   -keep class com.autonavi.aps.amapapi.model.**{*;}

#    搜索

    -keep   class com.amap.api.services.**{*;}

 #   2D地图

    -keep class com.amap.api.maps2d.**{*;}
    -keep class com.amap.api.mapcore2d.**{*;}

  #  导航

    -keep class com.amap.api.navi.**{*;}
    -keep class com.autonavi.**{*;}

#-keep class com.szrjk.widget.** {*;}

#xutils
-dontwarn com.lidroid.xutils.**
-keep class com.lidroid.xutils.** { *; }

-keep class * extends java.lang.annotation.Annotation { *; }

-dontwarn com.ut.mini.**
-keep class com.ut.mini.** {*;}

#galleryfinal
-keep class cn.finalteam.**
#-keep class cn.finalteam.galleryfinal.widget.*{*;}
#-keep class cn.finalteam.galleryfinal.widget.crop.*{*;}
#-keep class cn.finalteam.galleryfinal.widget.zoonview.*{*;}
#忽略错误
-ignorewarning

#glide  混淆
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

#eventbus  fragment中的函数
-keepclassmembers class ** {
    public void onEvent*(**);
    public void onEventMainThread*(**);
}

#share sdk 混淆 10.8
 -keep class cn.sharesdk.**{*;}
        -keep class com.sina.**{*;}
        -keep class **.R$* {*;}
        -keep class **.R{*;}
        -keep class com.mob.**{*;}
        -dontwarn com.mob.**
        -dontwarn cn.sharesdk.**
        -dontwarn **.R$*

# 保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#rxJava 混淆；如果开混淆，一定要配置
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}


#greendao  混淆
-keepclassmembers class * extends de.greenrobot.dao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties


##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.kapokhealth.entity.** { *; }

-keep class com.google.**{*;}
##---------------End: proguard configuration for Gson  ----------


