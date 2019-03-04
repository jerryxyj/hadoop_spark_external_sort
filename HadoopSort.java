import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class HadoopSort
{

	// this is the mapper class 
	public static class NewMapper
		extends Mapper<Object, Text, Text, Text>
	{
		private Text Key;
		private Text Value;
		public void map(Object key, Text value, Context context) 
			throws IOException, InterruptedException
		{
		//	StringTokenizer itr = new StringTokenizer(value.toString());
			Key = new Text(value.toString());	
			Value = new Text("");
			context.write(Key, Value);
		}
	}
	//the reducer class 
	
	public static class NewReducer extends Reducer<Text,Text,Text,Text>
	{
		private Text strLine = new Text();
		private Text strNewValue = new Text();
		public void reduce(Text Key, Text Value, Context context) 
			throws IOException, InterruptedException
		{
			strLine.set(Key.toString());
			strNewValue.set("");
			context.write(strLine, strNewValue);
		}
	}
	

	//main function
	public static void main(String[] args) throws Exception
	{

        if(args.length < 2) {
            System.out.println("lack some argument?");
            System.exit(1);
        }
		Configuration conf = new Configuration();
		conf.set("mapred.textoutputformat.separator", "");
		Job job = Job.getInstance(conf, "Hadoop Sort");
		job.setJarByClass(HadoopSort.class);
		job.setMapperClass(NewMapper.class);
		//job.setPartitionerClass(Partitioner.class);
		job.setCombinerClass(NewReducer.class);
		job.setReducerClass(NewReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setMapOutputKeyClass(Text.class); 		
		job.setMapOutputValueClass(Text.class);		
		FileInputFormat.addInputPath(job, new Path(args[0]));		
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setNumReduceTasks(200);
		//job.setNumMapTasks(4);
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
	

}
