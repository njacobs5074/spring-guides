package highlandcows

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CrudWithVaadinApplication {

	@Bean
	fun loadData(repository: CustomerRepository): CommandLineRunner {
		return CommandLineRunner { _: Array<String?>? ->
			// save a couple of customers
			repository.save(Customer("Jack", "Bauer"))
			repository.save(Customer("Chloe", "O'Brian"))
			repository.save(Customer("Kim", "Bauer"))
			repository.save(Customer("David", "Palmer"))
			repository.save(Customer("Michelle", "Dessler"))

			// fetch all customers
			log.info("Customers found with findAll():")
			log.info("-------------------------------")
			for (customer in repository.findAll()) {
				log.info(customer.toString())
			}
			log.info("")

			// fetch an individual customer by ID
			val customer = repository.findById(1L).get()
			log.info("Customer found with findOne(1L):")
			log.info("--------------------------------")
			log.info(customer.toString())
			log.info("")

			// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):")
			log.info("--------------------------------------------")
			for (bauer in repository
				.findByLastNameStartsWithIgnoreCase("Bauer")!!) {
				log.info(bauer.toString())
			}
			log.info("")
		}
	}

	companion object {
		private val log = LoggerFactory.getLogger(CrudWithVaadinApplication::class.java)
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(CrudWithVaadinApplication::class.java)
		}
	}
}