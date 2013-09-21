public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent serviceIntent = new Intent("com.myapp.MySystemService");
            context.startService(serviceIntent);
        }
    }
}