package com.springtest.mqtt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class MyTest {

	@Test
	public void testStream() throws IOException {
		String content=new String(Files.readAllBytes(Paths.get("C:/project/test/test.txt")),StandardCharsets.UTF_8);
		List<String> list=Arrays.asList(content.split("[\\P{L}]+"));
		
		list.forEach(w->System.out.println(w));
		long count=list.parallelStream().filter(w->w.length()>8).count();
		System.out.println(">>>>>>>>>>>>>>>>>>"+count);
		
		Stream<String> words=Stream.of("how","are","you");
		Stream<String> stream=Stream.empty();
		
		words.map(w->w.charAt(0)).forEach(w->System.out.println(w));
		//words.map(w->w.toUpperCase()).forEach(w->System.out.println(w));
		
		Stream<String> a=Stream.of("hello","hello","hello","are","we");
		a.distinct().forEach(System.out::println);
		System.out.println(">>>>>>>>>>>>>");
		Stream<String> b=Stream.of("We","are","zero","shi","Abbb");
		
		b.sorted(Comparator.comparing(String::toUpperCase)).forEach(System.out::println);
		System.out.println(">>>>11111111>>>>>>>>>");
		Stream<String> s=Stream.of("hello","hello","hello","are","we");
		Optional<String> op=s.filter(w->w.startsWith("a")).findAny();
		
		System.out.println(op.get());
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		Stream<String> t=Stream.of("111","222","333","are","we");
		Map<Object,Object> map=t.collect(Collectors.toMap(w->w, w->w));
		for(Map.Entry<Object, Object> e:map.entrySet()) {
			System.out.println(e.getKey()+">>>>>>>"+e.getValue());
		}
		
		Stream<String> c=Stream.of("111","222","333","are","we");
		String str=c.collect(Collectors.joining(","));
		System.out.println(str);
	}
	
	
	@Test
	public void testSummaryStatistics() {
		Stream<Integer> a=Stream.of(888,123,90,78,786);
		
		IntSummaryStatistics in=a.collect(Collectors.summarizingInt(w->w.intValue()));
		System.out.println("count>>>"+in.getCount());
		System.out.println("max>>>"+in.getMax());
		System.out.println("min>>>"+in.getMin());
		System.out.println("sum>>>"+in.getSum());
		System.out.println("avg>>>"+in.getAverage());
		
		
		
	}
	
	@Test
	public void testOtherStream() {
		IntStream intStream=IntStream.range(1, 101);
		IntSummaryStatistics in=intStream.summaryStatistics();
		long l=intStream.count();
		System.out.println("count>>>"+in.getCount());
		System.out.println("max>>>"+in.getMax());
		System.out.println("min>>>"+in.getMin());
		System.out.println("sum>>>"+in.getSum());
		System.out.println("avg>>>"+in.getAverage());
		
		System.out.println(l);
	}
	
	@Test
	public void testInstant() throws InterruptedException {
		Instant start=Instant.now();
		Thread.sleep(3000);
		Instant end=Instant.now();
		Duration dou=Duration.between(start,end);
		System.out.println(dou.toMillis());
		System.out.println(dou.getSeconds());
		
	}
	
	@Test
	public void testLocalDate() {
		LocalDate date=LocalDate.now();
		int year=date.getYear();
		int month=date.getMonth().getValue();
		System.out.println(year+">>>>>>>>>>"+month);
		System.out.println(date.toString());
		System.out.println("is leap year>>>"+date.isLeapYear());
		
		LocalDate a=LocalDate.of(2016, 1, 1).plusDays(255);
		//a.plusDays(255);
		System.out.println("test plus days>>>>"+a.toString());
	}
	
	@Test
	public void testZoneId() {
		Set<String> ids=ZoneId.getAvailableZoneIds();
		ids.forEach(System.out::println);
		ZonedDateTime zone=ZonedDateTime.now();
		System.out.println("test zoneddatetime>>>>"+zone.toString());
	}
	
	
	@Test
	public void testDateFormat() {
		LocalDateTime local=LocalDateTime.now();
		String format=DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(local);
		System.out.println("test DateTimeFormatter>>>>"+format);
	}
	
	@Test
	public void testString() {
		String str=String.join(",", ZoneId.getAvailableZoneIds());
		System.out.println(str);
	}
	
	public Stream<Long> lcgStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, v -> (a * v + c) % m);
    }
    public void task5() {
        lcgStream(25214903917L, 11, 1L << 48, System.currentTimeMillis()).limit(500000).forEach(System.out::println);
    }
	   
	
    @Test
    public void testFile() throws Exception {
    	Path path=Paths.get("C:/project/test/test.txt");
    	List<String> list=Files.readAllLines(path, StandardCharsets.UTF_8);
    	list.stream().forEach(System.out::println);
    	
    	
    }
    
	public static void main(String[] args) {
		MyTest m=new MyTest();
		m.task5();
		
	}

}
