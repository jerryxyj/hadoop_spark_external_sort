## Compile

make all

###########

All files are in the folder:
�� hadoopsort8GB.slurm:slurm script for hadoop 8GB
�� hadoopsort20GB.slurm:slurm script for hadoop 20GB
�� hadoopsort80GB.slurmslurm script for hadoop 80GB
�� sparksort8GB.slurm:slurm script for spark 8GB
�� sparksort20GB.slurm:slurm script for spark 20GB
�� sparksort80GB.slurm:slurm script for spark 8G0B
�� pom.xml (Maven)
�� HadoopSort.java:sorce code of hadoop sort
�� SparkSort.java:sorce code of spark sort
�� pa2b_report .pdf: pa2b report
�� readme.txt:it's me
�� HadoopSort8GB.log: all print out information of hadoop sort of 8GB
�� HadoopSort20GB.log:all print out information of hadoop sort of 20GB
�� HadoopSort80GB.log:all print out information of hadoop sort of 80GB
�� SparkSort8GB.log:all print out information of spark sort of 8GB
�� SparkSort20GB.log:all print out information of spark sort of 20GB
�� SparkSort80GB.log:all print out information of spark sort of 20GB



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













