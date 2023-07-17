package com.devsuperior.order;

import com.devsuperior.order.entities.Order;
import com.devsuperior.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Numero do pedido? ");
		int num = sc.nextInt();

		System.out.println("Valor do pedido? ");
		double basic = sc.nextDouble();

		System.out.println("Desconto do pedido? ");
		double discount = sc.nextDouble();

		Order order = new Order(num,basic,discount);

		System.out.println("Pedido codigo: " + order.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order));

	}
}
