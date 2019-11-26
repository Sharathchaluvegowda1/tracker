
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GetTimeEntryLoadSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8080")
		.acceptHeader("application/json")
  	.contentTypeHeader("application/json")

	val scn = scenario("GetTimesheetSimulation")
		.exec(http("get-timesheet")
			.get("/timesheets/1")

	setUp(scn.inject(
		constantConcurrentUsers(10) during (1 seconds))).throttle(
		reachRps(10) in (0 seconds),
		holdFor(2 minutes)
	).protocols(httpProtocol)


}