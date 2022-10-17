package com.sanketika.metrics

case class Telemetry(
                      eid: String,
                      progress: ProgressData,
                      edata: EData,
                      actor: Actor,
                      context: ContextDetails,
                      `object`: ObjectDetails) {

}

case class Actor(
                  `type`: String,
                  id: String
                )
case class EData(
                  state: String,
                  summary: Seq[Summary],
                  props: List[String],
                  `type`: String,
                  pageid: String
                )
case class Summary (
                     progress: Option[Int]

                   )

case class ProgressData(
                         userId: String,
                         completed: Int
                       )

case class ObjectDetails(
                          id: String,
                          `type`: String
                        )
case class ContextDetails(
                           sid: String,
                           did: String,
                           channel: String
                         )
