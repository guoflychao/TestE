package cn.tedu.test12131;

import java.util.ArrayList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private PullToRefreshListView lv;
    private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 List<String> arr =new ArrayList<String>();
	        arr.add("test");
	        arr.add("test1");
	        lv = (PullToRefreshListView) findViewById(R.id.mylv);
	        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
	        lv.setAdapter(adapter);
	        lv.setOnRefreshListener(new OnRefreshListener<ListView>() {

					 @Override
			            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
			                // TODO Auto-generated method stub
			                new AsyncTask<Void, Void, Void>() {
			                /**
			                 * 上拉刷新，下拉加载的案例
			                 * 
			                 */
			                    @Override
			                    protected Void doInBackground(Void... params) {
			                        // TODO Auto-generated method stub
			                        try {
			                            Thread.sleep(2800);
			                        } catch (InterruptedException e) {
			                            // TODO Auto-generated catch block
			                            e.printStackTrace();
			                        }
			                        return null;
			                    }
			                    protected void onPostExecute(Void result) {
			                        adapter.addAll("test","成功");
			                        lv.onRefreshComplete();
			                    };
			                }.execute();
			                
			            }
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
