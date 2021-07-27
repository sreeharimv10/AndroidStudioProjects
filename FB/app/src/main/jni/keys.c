#include <jni.h>
#include <stdio.h>

JNIEXPORT jstring JNICALL
Java_com_example_fb_RegisterActivity_getNativeKey1(JNIEnv *env, jobject instance)
{
 return (*env)->  NewStringUTF(env, "QUl6YVN5Qk05anY2TFZDdWlvelpGZVgtV1o5UDh2RC0yaWhFYlVF");
}
