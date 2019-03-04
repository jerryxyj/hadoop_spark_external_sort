## Compile

make all

###########

All files are in the folder:
¡ñ hadoopsort8GB.slurm:slurm script for hadoop 8GB
¡ñ hadoopsort20GB.slurm:slurm script for hadoop 20GB
¡ñ hadoopsort80GB.slurmslurm script for hadoop 80GB
¡ñ sparksort8GB.slurm:slurm script for spark 8GB
¡ñ sparksort20GB.slurm:slurm script for spark 20GB
¡ñ sparksort80GB.slurm:slurm script for spark 8G0B
¡ñ pom.xml (Maven)
¡ñ HadoopSort.java:sorce code of hadoop sort
¡ñ SparkSort.java:sorce code of spark sort
¡ñ pa2b_report .pdf: pa2b report
¡ñ readme.txt:it's me
¡ñ HadoopSort8GB.log: all print out information of hadoop sort of 8GB
¡ñ HadoopSort20GB.log:all print out information of hadoop sort of 20GB
¡ñ HadoopSort80GB.log:all print out information of hadoop sort of 80GB
¡ñ SparkSort8GB.log:all print out information of spark sort of 8GB
¡ñ SparkSort20GB.log:all print out information of spark sort of 20GB
¡ñ SparkSort80GB.log:all print out information of spark sort of 20GB



To compile the code of Hadoop, you can type bash commend as:

javac -classpath $(hadoop classpath) HadoopSort.java

jar cvf HadoopSort.jar H*.class 

To compile the code of Spark, you can type bash commend as:

javac -classpath /opt/spark-2.3.0-bin-hadoop2.7/jars/spark-core_2.11-2.3.0.jar:/opt/spark-2.3.0-bin-hadoop2.7/jars/spark-sql_2.11-2.3.0.jar:/opt/spark-2.3.0-bin-hadoop2.7/jars/scala-compiler-2.11.8.jar:/opt/spark-2.3.0-bin-hadoop2.7/jars/scala-library-2.11.8.jar SparkSort.java

jar cvf SparkSort.jar S*.class

or you can run mvn package

***************************************
And after that you can submit job by type command:
sbatch hadoop8/20/80GB.slurm to submit hadoop job
sbatch spark8/20/80GB.slurm to submit spark job

***************************************

All the sorted result is verified by teravalidate

Author: Yunjie Xu













