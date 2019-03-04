import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;


public class SparkSort {
	
	public static void main(String[] args) {
		
		SparkConf conf =new SparkConf().setAppName("sparksort").setMaster("yarn");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile(args[0]);
		JavaPairRDD<String, String> sort = lines
			    .mapToPair(new PairFunction<String, String, String>(){
					public Tuple2<String, String> call(String s) {
						String key = s;
						String value = "";
						return new Tuple2<String, String>(key, value);
					}			    	
			    })
			    .sortByKey(true);
		sort.map(new Function<Tuple2<String, String>, String>() {
            public String call(Tuple2<String, String> t) throws Exception {
                String newLine=t._1().toString()+"\r";
                return newLine;
                }
		}).saveAsTextFile(args[1]);


	};


}
